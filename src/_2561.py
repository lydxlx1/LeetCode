"""
LeetCode 2561 - Rearranging Fruits

Counting + Greedy

Several things to pay attention:
0. Goal of the problem is to make both baskets (when sorted) equal, not make their sum equal, 
   where the latter is a much harder problem.

1. The optimal cost to achieve the same effect as swap (i, j) is not always min(basket1[i], basket2[j]).
   It is indeed the minimum of that and 2 * M, where M = min(basket1, basket2).

   To see why, assume that the global minimum element is located at basket2[k], where j != k.
   Then, consider the swaps (i, k) followed by (i, j), where
   - The cost of both swaps are equal to M.
   - The result after both swaps is "equivalent" to the original swap (i, j), except that the order of
     the final element at basket2[j] and basket2[k] is swapped, which is okay since order is not considered
     in this problem.

2. No solution if and only if there exists an odd frequency of the union of basket1 and basket2.

Time complexity: O(n log n)
Space complexity: O(n)
"""
from collections import Counter
from sortedcontainers import SortedList

class Solution:
    def minCost(self, basket1: List[int], basket2: List[int]) -> int:
        total = Counter(basket1) + Counter(basket2)
        A, B = SortedList(basket1), SortedList(basket2)
        min_cost = min(A[0], B[0])
        
        for k, v in total.items():
            if v % 2 != 0:
                return -1
            for _ in range(v // 2):
                A.discard(k)
                B.discard(k)

        ans = 0
        while A:
            assert B
            A, B = (B, A) if A[0] > B[0] else (A, B)  # Now, A[0] is always smaller
            ans += min(A[0], 2 * min_cost)
            A.pop(0)  # Pop A's minimum
            B.pop(-1)  # Pop B's maximum

        return ans