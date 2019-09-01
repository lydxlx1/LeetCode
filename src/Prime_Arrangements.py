"""Prime Arrangements

Math
"""
from math import *


class Solution:
    def numPrimeArrangements(self, n: int) -> int:
        def is_prime(x: int) -> bool:
            if x < 2:
                return False
            return all(x % i != 0 for i in range(2, min(int(sqrt(x)) + 10, x)))

        mod = 10 ** 9 + 7

        def fac(x: int) -> int:
            return 1 if x <= 1 else x * fac(x - 1) % mod

        cnt = sum(1 for i in range(1, n + 1) if is_prime(i))
        return fac(cnt) * fac(n - cnt) % mod
