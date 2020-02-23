"""1362. Closest Divisors

Brute-force
There can be at most sqrt(n) pairs of divisors, so we can just enumerate all of them.

Time: O(sqrt(n))
Space: O(sqrt(n)), which can be further optimized to O(1).
"""
from typing import List


class Solution:
    def closestDivisors(self, num: int) -> List[int]:
        def factors(n: int):
            i = 1
            while i * i <= n:
                if n % i == 0:
                    yield (i, n // i)
                i += 1

        return min(list(factors(num + 1)) + list(factors(num + 2)), key=lambda key: key[1] - key[0])
