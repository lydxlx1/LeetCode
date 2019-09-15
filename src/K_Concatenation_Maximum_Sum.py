"""K-Concatenation Maximum Sum

DP + Prefix Sum"""
from typing import *


class Solution:
    def kConcatenationMaxSum(self, arr: List[int], k: int) -> int:
        ans = 0

        # Regular DP for computing max sub-array sum
        f = arr.copy()
        for i in range(1, len(arr)):
            if f[i - 1] > 0:
                f[i] += f[i - 1]
        ans = max(ans, max(f))

        # Now, consider the answer of using at least two copies.
        prefix_sum = arr.copy()
        suffix_sum = arr.copy()
        for i in range(len(arr) - 2, -1, -1):
            suffix_sum[i] += suffix_sum[i + 1]
        for i in range(1, len(arr)):
            prefix_sum[i] += prefix_sum[i - 1]
        if k >= 2:
            ans = max(ans, max(prefix_sum) + max(suffix_sum))
            ans = max(ans, max(prefix_sum) + max(suffix_sum) + (k - 2) * sum(arr))
        return ans % (10 ** 9 + 7)
