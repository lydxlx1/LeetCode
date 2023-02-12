"""
LeetCode 2565 - Subsequence With the Minimum Score

Greedy + DP

Enumerate the leftmost deletion position of t and then find the
optimal rightmost deletion position to minimize the cost w.r.t.
the left deletion position.

See the comment in below for more details.
"""
from typing import *
from math import inf
import re
import random
import sys


class Solution:
    def minimumScore(self, s: str, t: str) -> int:

        # max_matched_t_suffix[i] means the starting location of the longest
        # suffix of t such that s[i:] contains that as a subsequence.
        # That is, max_matched_t_suffix[i] is the smallest index j such that
        # s[i:] contains t[j:] as a subsequence.
        max_matched_t_suffix = [len(t)] * (len(s) + 1)
        for i in reversed(range(len(s))):
            max_matched_t_suffix[i] = max_matched_t_suffix[i + 1]
            if max_matched_t_suffix[i] > 0 and s[i] == t[max_matched_t_suffix[i] - 1]:
                max_matched_t_suffix[i] -= 1

        if max_matched_t_suffix[0] == 0:
            return 0

        ans = len(t)
        ptr_s = 0
        for ptr_t in range(len(t)):
            # Assume leftmost deletion position in t is ptr_t
            if ptr_s <= len(s):
                left = ptr_t
                right = max_matched_t_suffix[ptr_s] - 1
                ans = min(ans, max(1, right - left + 1))

            # At this moment, we must match t[ptr_t]
            while ptr_s < len(s) and s[ptr_s] != t[ptr_t]:
                ptr_s += 1
            ptr_s += 1  # Matching this element, or ptr_s is already overflow and such element doesn't exist.

        return ans
