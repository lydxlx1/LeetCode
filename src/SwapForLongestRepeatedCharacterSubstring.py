"""
Swap For Longest Repeated Character Substring

Greedy

Good problem as there are many corner cases.
"""
from typing import *
from collections import *


class Solution:
    def maxRepOpt1(self, text: str) -> int:
        positions = defaultdict(list)
        for i in range(len(text)):
            positions[text[i]].append(i)

        def compute(a: List[int]) -> int:
            intervals = []

            begin = end = a[0]
            for i in a[1:]:
                if i == end + 1:
                    end = i
                else:
                    intervals.append((begin, end))
                    begin = end = i
            intervals.append((begin, end))

            ans = max(end - begin + 1 for begin, end in intervals)
            if len(intervals) > 1:
                ans += 1  # Example: aaabbaaa
            for i in range(len(intervals) - 1):
                if intervals[i][1] + 2 == intervals[i + 1][0]:  # aa...aa?aa...aa
                    local_max = (intervals[i + 1][1] - intervals[i + 1][0] + 1) + (intervals[i][1] - intervals[i][0] + 1)
                    if len(intervals) > 2:
                        local_max += 1
                    ans = max(ans, local_max)

            return ans

        return max(compute(arr) for arr in positions.values())

