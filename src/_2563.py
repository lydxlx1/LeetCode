"""
LeetCode 2563 - Count the Number of Fair Pairs

1. First transform the counting problem into the following one
   "Find all pairs, 0 <= i < j < n, such that nums[i] + nums[j] <= upper".
   Called it f(x).

2. It then follows that the answer to the original problem is just
   f(upper) - f(lower - 1).

3. Computing f(upper) is similar to 2-sum.
"""
from sortedcontainers import SortedList

class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        def count(nums, upper):
            ans = 0
            A = SortedList()
            for num in nums:
                ans += A.bisect_right(upper - num)
                A.add(num)
            return ans

        return count(nums, upper) - count(nums, lower - 1)
