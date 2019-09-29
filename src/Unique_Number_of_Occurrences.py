"""Unique Number of Occurrences"""

from typing import *
from collections import *


class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        values = Counter(arr).values()
        return len(values) == len(set(values))
