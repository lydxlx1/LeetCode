"""Ugly Number III

Bisection + Inclusion-Exclusion"""

import math


class Solution:
    def nthUglyNumber(self, n: int, a: int, b: int, c: int) -> int:
        ab = a * b // math.gcd(a, b)
        ac = a * c // math.gcd(a, c)
        bc = b * c // math.gcd(b, c)
        abc = ab * c // math.gcd(ab, c)

        def cnt(n: int) -> int:
            cnt = 0
            cnt += n // a + n // b + n // c
            cnt -= n // ab + n // ac + n // bc
            cnt += n // abc
            return cnt

        left = 0
        right = 3 * (10 ** 9)
        while left + 1 < right:
            mid = (left + right) // 2
            if cnt(mid) < n:
                left = mid
            else:
                right = mid
        return right
