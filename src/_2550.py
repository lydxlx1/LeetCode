"""
LeetCode 2550 - Count Collisions of Monkeys on a Polygon
"""
class Solution:
    def monkeyMove(self, n: int) -> int:
        mod = 1000000007

        def pow(a: int, n: int) -> int:
            ans = 1
            while n > 0:
                if n % 2 == 1:
                    ans = ans * a % mod
                a = a * a % mod
                n //= 2
            return ans

        ans = (pow(2, n) + mod - 2) % mod
        return ans
