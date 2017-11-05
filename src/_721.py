"""
LeetCode 721 - Accounts Merge

Disjoint Set + Hashset
"""

from collections import defaultdict


class Solution:
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        parent = {}
        email_to_name = {}

        def find(i):
            if parent[i] != i:
                parent[i] = find(parent[i])
            return parent[i]

        def union(i, j):
            parent[find(i)] = find(j)

        for account in accounts:
            name = account[0]
            for email in account[1:]:
                if email not in parent:
                    parent[email] = email
                email_to_name[email] = name
                union(email, account[1])  # account[1]: the first email

        trees = defaultdict(list)
        for email in parent.keys():
            trees[find(email)].append(email)

        return [[email_to_name[root]] + sorted(emails) for (root, emails) in trees.items()]
