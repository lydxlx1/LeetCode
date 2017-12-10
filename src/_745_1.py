"""
LeetCode 745 - Prefix and Suffix Search

1. Hash prefix and hash suffix, separately.
2. Search with heuristic.
"""
from collections import defaultdict


class WordFilter:
    def __init__(self, words):
        """
        :type words: List[str]
        """
        self.prefix_list = defaultdict(list)
        self.prefix_set = defaultdict(dict)
        self.suffix_list = defaultdict(list)
        self.suffix_set = defaultdict(dict)

        for i in reversed(range(len(words))):  # iterate from most weighted to least weighted
            for j in range(len(words[i]) + 1):
                prefix = words[i][0:j]
                suffix = words[i][j:len(words[i])]

                self.prefix_list[prefix].append(i)
                self.prefix_set[prefix][i] = i
                self.suffix_list[suffix].append(i)
                self.suffix_set[suffix][i] = i

    def f(self, prefix, suffix):
        """
        :type prefix: str
        :type suffix: str
        :rtype: int
        """
        if prefix in self.prefix_list and suffix in self.suffix_list:
            if len(self.prefix_list[prefix]) < len(self.suffix_list[suffix]):
                list = self.prefix_list[prefix]
                set = self.suffix_set[suffix]
            else:
                list = self.suffix_list[suffix]
                set = self.prefix_set[prefix]
            for i in list:
                if i in set:
                    return i
            return -1
        else:
            return -1


sol = WordFilter(['apple'])
print(sol.f('a', 'e'))
print(sol.f('b', ''))
