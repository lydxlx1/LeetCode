"""1383. Maximum Performance of a Team

Greedy
Enumerate the engineer that has the minimum efficiency in the team. When that engineer is fixed, find those (at most) k engineers that have top speed.
This algorithm can be implemented efficiently by (i) a pre-sorting on efficiency in decresing order and (ii) using a heap or BST to maintain top-k speed.
"""

from sortedcontainers import SortedList
from typing import List


class Solution:
    def maxPerformance(self, n: int, speed: List[int], efficiency: List[int], k: int) -> int:
        ans = 0
        top_speed = SortedList()
        sum_speed = 0
        for ef, sp in reversed(sorted(zip(efficiency, speed))):
            sum_speed += sp
            top_speed.add(sp)
            if len(top_speed) > k:
                sum_speed -= top_speed.pop(0)
            ans = max(ans, ef * sum_speed)

        return ans % 1000000007
