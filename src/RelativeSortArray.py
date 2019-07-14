"""
Relative Sort Array
"""

from typing import *


class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        index = dict(zip(arr2, range(len(arr2))))
        pairs = [(index[i] if i in index else 1 << 29, i) for i in arr1]
        return [val for _, val in sorted(pairs)]
