"""Make Array Strictly Increasing

DP
"""

from typing import *
import bisect


class Solution:
    def makeArrayIncreasing(self, arr1: List[int], arr2: List[int]) -> int:
        arr2 = sorted(set(arr2))  # Dedupe and sort
        memo = {}
        inf = 1 << 29

        def f(i: int, last_upper_bound: int) -> int:
            if i == 0:
                return 0 if arr1[0] <= last_upper_bound else 1 if arr2[0] <= last_upper_bound else inf
            if (i, last_upper_bound) in memo:
                return memo[i, last_upper_bound]

            ans = inf
            if arr1[i] <= last_upper_bound:
                ans = min(ans, f(i - 1, arr1[i] - 1))
            index = bisect.bisect_right(arr2, last_upper_bound) - 1
            if index >= 0:
                ans = min(ans, 1 + f(i - 1, arr2[index] - 1))

            memo[i, last_upper_bound] = ans
            return ans

        n = len(arr1)
        ans = min(f(n - 1, arr1[-1]), f(n - 1, arr2[-1]))
        return ans if ans < inf else -1
