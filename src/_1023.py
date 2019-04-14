"""
LeetCode 1023 - Camelcase Matching

Brute-force
"""

from typing import *


class Solution:
    def camelMatch(self, queries: List[str], pattern: str) -> List[bool]:
        ans = []
        for query in queries:
            i = j = 0
            while True:
                if i < len(query) and j < len(pattern) and query[i] == pattern[j]:
                    i += 1
                    j += 1
                elif i < len(query) and query[i].islower():
                    i += 1
                else:
                    break
            ans.append(i == len(query) and j == len(pattern))
        return ans
