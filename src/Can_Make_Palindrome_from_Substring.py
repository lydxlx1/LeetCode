"""Can Make Palindrome from Substring

Greedy
Note that we can REARRANGE every substring...

"""
from typing import *


class Solution:
    def canMakePaliQueries(self, s: str, queries: List[List[int]]) -> List[bool]:
        n = len(s)
        s = "." + s
        prefix_sum = [[0] * 26 for i in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(26):
                prefix_sum[i][j] = prefix_sum[i - 1][j]
            prefix_sum[i][ord(s[i]) - ord('a')] += 1
        return [
            k >= sum(1 for ch in range(26) if (prefix_sum[r + 1][ch] - prefix_sum[l][ch]) % 2 != 0) // 2
            for l, r, k in queries
        ]
