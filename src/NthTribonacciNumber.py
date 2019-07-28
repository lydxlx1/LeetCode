"""
N-th Tribonacci Number
"""


class Solution:
    def tribonacci(self, n: int) -> int:
        T = [0] * 40
        T[0] = 0
        T[1] = 1
        T[2] = 1
        for i in range(3, len(T)):
            T[i] = T[i - 1] + T[i - 2] + T[i - 3]
        return T[n]
