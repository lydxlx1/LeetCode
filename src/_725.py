"""
LeetCode 725 - Split Linked List in Parts

Greedy method
"""


class Solution:
    def splitListToParts(self, root, k):
        """
        :type root: ListNode
        :type k: int
        :rtype: List[ListNode]
        """
        ans = []
        len, node = (0, root)
        while node:
            len += 1
            node = node.next

        while k > 0:
            sub_len = (len + k - 1) // k  # ceiling(len / k)
            node = root
            for i in range(sub_len - 1):
                node = node.next if node else node

            ans.append(root)
            root = node.next if node else node
            if node:
                node.next = None

            k -= 1
            len -= sub_len

        return ans

