"""
Minimum Cost Tree From Leaf Values

DP
"""

from typing import *


class Solution:
    memo = {}

    def mctFromLeafValues(self, arr: List[int]) -> int:
        if len(arr) == 1:
            return 0

        key = tuple(arr)
        if key in self.memo:
            return self.memo[key]
        ans = 1 << 31
        for i in range(1, len(arr)):
            left, right = arr[:i], arr[i:]
            ans = min(ans, self.mctFromLeafValues(left) + self.mctFromLeafValues(right) + max(left) * max(right))
        self.memo[key] = ans
        return ans
