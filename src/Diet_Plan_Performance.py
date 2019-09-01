"""Diet Plan Performance

Sliding Window
"""
from typing import *


class Solution:
    def dietPlanPerformance(self, calories: List[int], k: int, lower: int, upper: int) -> int:
        sum = ans = 0
        for i in range(len(calories)):
            sum += calories[i]
            if i - k >= 0:
                sum -= calories[i - k]
            if i >= k - 1:
                if sum < lower:
                    ans -= 1
                elif sum > upper:
                    ans += 1
                else:
                    pass
        return ans
