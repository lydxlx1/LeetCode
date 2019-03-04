"""
LeetCode 1002 - Find Common Characters
"""
from sys import *
from typing import *
from collections import *
import string


class Solution:
    def commonChars(self, A: List[str]) -> List[str]:
        counter = Counter(A[0])
        for i in range(1, len(A)):
            counter &= Counter(A[i])
        return counter.elements()
