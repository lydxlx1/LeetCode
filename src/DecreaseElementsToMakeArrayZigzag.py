"""
Decrease Elements To Make Array Zigzag

Greedy
Note that we can only decrease numbers, then it makes sense to only decrease those numbers that are at valley positions.
"""
from typing import *


class Solution:
    def movesToMakeZigzag(self, nums: List[int]) -> int:
        ans = 1 << 29

        for start in [0, 1]:
            cnt = 0
            for i in range(start, len(nums), 2):
                tmp = 0
                if i - 1 >= 0:
                    tmp = max(tmp, nums[i] - nums[i - 1] + 1)
                if i + 1 < len(nums):
                    tmp = max(tmp, nums[i] - nums[i + 1] + 1)
                cnt += tmp
            ans = min(ans, cnt)

        return ans


