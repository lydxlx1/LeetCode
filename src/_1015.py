"""
LeetCode 1015 - Smallest Integer Divisible by K

Math
I'm being lazy here. Ideally, we could return -1 if seeing a visited modulo.
"""


class Solution:
    def smallestRepunitDivByK(self, K: int) -> int:
        n = 1
        for i in range(1, K + 10):
            if n % K == 0:
                return i
            n = (n * 10 + 1) % K
        return -1
