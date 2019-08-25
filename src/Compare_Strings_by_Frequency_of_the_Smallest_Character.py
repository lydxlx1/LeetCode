"""
Compare Strings by Frequency of the Smallest Character

Binary Search
"""
from typing import *
from collections import *
from bisect import *


class Solution:
    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        freq = [Counter(s)[min(s)] for s in words]
        freq.sort()
        # bisect_left or bisect_right returns the index of the target element AFTER insertion, where the length of the
        # "inserted" list will be one more than its original length.
        return [len(words) - bisect_right(freq, Counter(q)[min(q)]) for q in queries]
