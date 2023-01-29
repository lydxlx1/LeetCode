"""
LeetCode 2549 - Count Distinct Numbers on Board

Simulation approach
"""
class Solution:
    def distinctIntegers(self, n: int) -> int:
        nums = {n}
        while True:
            new_nums = set(nums)
            for x in nums:
                for i in range(1, n + 1):
                    if x % i == 1:
                        new_nums.add(i)
            if len(new_nums) > len(nums):
                nums = new_nums
            else:
                break
        return len(nums)

