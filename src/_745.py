"""
LeetCode 745 - Prefix and Suffix Search

1. Hash (prefix, suffix)
2. O(1)-time search
"""


class WordFilter:
    def __init__(self, words):
        """
        :type words: List[str]
        """
        self.map = {}
        for i in range(len(words)):
            word = words[i]
            for j in range(len(word) + 1):
                prefix = word[0:j]
                for k in range(len(word) + 1):
                    suffix = word[k:len(word)]
                    self.map[prefix + '.' + suffix] = i

    def f(self, prefix, suffix):
        """
        :type prefix: str
        :type suffix: str
        :rtype: int
        """
        key = prefix + '.' + suffix
        return self.map[key] if key in self.map else -1

