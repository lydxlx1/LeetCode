"""
LeetCode 826 - Most Profit Assigning Work

BIT solution
"""

class Solution:
    def maxProfitAssignment(self, difficulty, profit, worker):
        """
        :type difficulty: List[int]
        :type profit: List[int]
        :type worker: List[int]
        :rtype: int
        """
        bit = [0] * 111111
        for di, pr in zip(difficulty, profit):
            i = di
            while i < len(bit):
                bit[i] = max(bit[i], pr)
                i += i & -i

        ans = 0
        for each_worker in worker:
            i = each_worker
            max_profit = 0
            while i > 0:
                max_profit = max(max_profit, bit[i])
                i -= i & -i
            ans += max_profit

        return ans
