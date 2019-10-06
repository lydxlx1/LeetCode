"""Play with Chips

Math"""

from typing import *
from collections import *


class Solution:
    def minCostToMoveChips(self, chips: List[int]) -> int:
        return len(chips) - max(Counter(i % 2 for i in chips).values())
