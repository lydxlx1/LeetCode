"""
LeetCode 720 - Longest Word in Dictionary

Sorting + DP
"""


class Solution:
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        valid = {""}
        for word in sorted(words):
            if word[:-1] in valid:
                valid.add(word)
        return min(((-len(s), s) for s in valid))[1]

