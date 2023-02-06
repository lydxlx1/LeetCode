"""
LeetCode 2553 - Separate the Digits in an Array

1-liner solution
"""
class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        return [int(digit) for num in nums for digit in str(num)]