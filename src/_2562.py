"""
LeetCod3 2562 - Find the Array Concatenation Value

Simulation
"""
class Solution:
    def findTheArrayConcVal(self, nums: List[int]) -> int:
        i = 0
        j = len(nums) - 1
        ans = 0
        while i <= j:
            if i < j:
                ans += int(str(nums[i]) + str(nums[j]))
            else:
                ans += nums[i]
            i += 1
            j -= 1
        return ans
