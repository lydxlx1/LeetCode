"""
LeetCode 1072 - Flip Columns For Maximum Number of Equal Rows

At most two (different) row masks can be converted to equal rows.
"""

from typing import *
from collections import *


class Solution:
    def maxEqualRowsAfterFlips(self, matrix: List[List[int]]) -> int:
        counter = Counter(["".join(str(i) for i in row) for row in matrix])
        ans = 0
        for a in counter.keys():
            ans = counter[a]
            for b in counter.keys():
                complement = True
                for i in range(len(a)):
                    if a[i] == b[i]:
                        complement = False
                        break
                if complement:
                    ans = max(ans, counter[a] + counter[b])
        return ans
