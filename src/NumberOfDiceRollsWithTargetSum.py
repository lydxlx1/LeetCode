"""
Number of Dice Rolls With Target Sum

Counting
"""


class Solution:
    def numRollsToTarget(self, d: int, f: int, target: int) -> int:

        mod = 10 ** 9 + 7

        def dfs(d, target, memo):
            if d == 1:
                return 1 if 1 <= target <= f else 0
            if (d, target) in memo:
                return memo[d, target]

            cnt = 0
            for i in range(1, f + 1):
                if i > target:
                    break
                cnt += dfs(d - 1, target - i, memo)
                cnt %= mod
            memo[d, target] = cnt
            return cnt

        return dfs(d, target, {})
