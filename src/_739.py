"""
LeetCode 739 - Daily Temperatures

Using a stack
"""
class Solution:
    def dailyTemperatures(self, a):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        res = [0] * len(a)
        stack = []
        for i in range(len(a)):
            while stack and a[i] > a[stack[-1]]:
                res[stack[-1]] = i - stack[-1]
                stack.pop()
            stack.append(i)
        return res

