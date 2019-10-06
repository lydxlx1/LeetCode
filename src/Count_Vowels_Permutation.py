"""Count Vowels Permutation

Counting"""

from typing import *
from collections import defaultdict


class Solution:
    def longestSubsequence(self, arr: List[int], difference: int) -> int:
        d = defaultdict(int)
        for i in arr:
            d[i] = d[i - difference] + 1
        return max(d.values())
