"""
LeetCode 2558 - Take Gifts From the Richest Pile

Simulation using Heap

Time complexity: O(n log n)
Space complexity: O(n)
"""
from sortedcontainers import SortedList

class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        gifts = SortedList(gifts)
        for _ in range(k):
            g = gifts.pop()
            sqrt = (int)(g**(0.5))
            if (sqrt+1)*(sqrt+1) <= g:
                sqrt += 1
            gifts.add(sqrt)
        return sum(gifts)
            