"""
Counting
"""


class Solution:
    def numTilePossibilities(self, tiles: str) -> int:

        memo = {}

        def f(s: str):
            if s == '':
                return 1
            if s in memo:
                return memo[s]
            ans = 1
            for ch in set(s):
                ans += f(''.join(sorted(s.replace(ch, '', 1))))
            memo[s] = ans
            return ans

        return f(''.join(sorted(tiles))) - 1  # exclude the empty string
