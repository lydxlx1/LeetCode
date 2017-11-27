import itertools

"""
LeetCode 737 - Sentence Similarity II

Union-find Set
"""


class Solution:
    def areSentencesSimilarTwo(self, words1, words2, pairs):
        """
        :type words1: List[str]
        :type words2: List[str]
        :type pairs: List[List[str]]
        :rtype: bool
        """
        if len(words1) != len(words2):
            return False

        parent = {}
        for word in itertools.chain(words1, words2, *pairs):
            parent[word] = word

        def find(i):
            if parent[i] != i:
                parent[i] = find(parent[i])
            return parent[i]

        for a, b in pairs:
            parent[find(a)] = find(b)

        for a, b in zip(words1, words2):
            if find(a) != find(b):
                return False

        return True
