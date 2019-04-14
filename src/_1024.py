"""
LeetCode 1024 - Video Stitching

DP
"""

from typing import *


class Solution:
    def videoStitching(self, clips: List[List[int]], T: int) -> int:
        if T == 0:
            return 1 if [1 for clip in clips if clip[0] == 0] else -1

        inf = 1 << 29
        f = [inf] * (T + 1)
        f[0] = 0

        for i in range(1, T + 1):
            for begin, end in clips:
                if begin < i <= end:
                    f[i] = min(f[i], 1 + f[begin])

        return f[T] if f[T] < inf else -1
