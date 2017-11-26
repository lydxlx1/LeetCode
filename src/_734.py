from collections import defaultdict


"""
LeetCode 734 - Sentence Similarity
"""
class Solution:
    def areSentencesSimilar(self, words1, words2, pairs):
        """
        :type words1: List[str]
        :type words2: List[str]
        :type pairs: List[List[str]]
        :rtype: bool
        """
        if len(words1) != len(words2):
            return False

        similar = defaultdict(list)
        for a, b in pairs:
            similar[a].append(b)
            similar[b].append(a)

        for a, b in zip(words1, words2):
            if not (a == b or a in similar[b] or b in similar[a]):
                return False
        return True
