"""
LeetCode 826 - Most Profit Assigning Work

Greedy
"""

class Solution:
    def maxProfitAssignment(self, difficulty, profit, worker):
        """
        :type difficulty: List[int]
        :type profit: List[int]
        :type worker: List[int]
        :rtype: int
        """

        map = {}
        difficulty = difficulty + worker
        profit = profit + [0 for _ in worker]
        max_profit = 0
        for di, pr in sorted(zip(difficulty, profit)):
            max_profit = max(max_profit, pr)
            map[di] = max_profit

        return sum(map[each_worker] for each_worker in worker)
