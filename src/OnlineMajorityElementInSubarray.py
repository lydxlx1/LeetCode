"""
Online Majority Element In Subarray

Randomization + Bisect

When the window size is small, just brute force.
When the window size is big, randomize the majority. This will guarantee 50% success rate when the majority exists.
"""
from typing import *
from collections import *
from bisect import *
from random import *


class MajorityChecker:

    def __init__(self, arr: List[int]):
        self.occurrence = defaultdict(list)
        for i in range(len(arr)):
            self.occurrence[arr[i]].append(i)
        self.arr = arr

    def query(self, left: int, right: int, threshold: int) -> int:
        if right - left + 1 < 50:
            cnt = defaultdict(int)
            max, arg_max = 0, -1
            for i in range(left, right + 1):
                cnt[self.arr[i]] += 1
                if cnt[self.arr[i]] > max:
                    max = cnt[self.arr[i]]
                    arg_max = self.arr[i]
            return arg_max if max >= threshold else -1
        else:
            for _ in range(50):  # > 0.5 success rate if majority element exists
                key = self.arr[randint(left, right)]
                arr = self.occurrence[key]

                begin = bisect_left(arr, left)
                if begin >= len(arr):
                    continue
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

checker = MajorityChecker([1, 1, 2, 2, 1, 1])
print(checker.query(0, 5, 4));
print(checker.query(0, 3, 3));
print(checker.query(2, 3, 2));
