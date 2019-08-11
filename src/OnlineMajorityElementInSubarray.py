"""
Online Majority Element In Subarray

Greedy + Bisect

I'm not sure whether this is the optimal solution, but it works.
"""
from typing import *
from collections import *
from bisect import *


class MajorityChecker:

    def __init__(self, arr: List[int]):
        occurrence = defaultdict(list)
        for i in range(len(arr)):
            occurrence[arr[i]].append(i)
        self.occurrence = sorted(occurrence.items(), key=lambda arr: -len(arr[1]))  # most frequent -> least frequent

    def query(self, left: int, right: int, threshold: int) -> int:
        for key, arr in self.occurrence:
            if len(arr) < threshold:
                break  # Early pruning

            begin = bisect_left(arr, left)
            if begin >= len(arr):
                continue  # No solution
            if arr[begin] < left:
                begin += 1
            end = bisect_right(arr, right)
            if end >= len(arr) or arr[end] > right:
                end -= 1
            if end - begin + 1 >= threshold:
                return key

        return -1

# Your MajorityChecker object will be instantiated and called as such:
# obj = MajorityChecker(arr)
# param_1 = obj.query(left,right,threshold)
