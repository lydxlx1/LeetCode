"""
LeetCode 2564 - Substring XOR Queries

1. Since val ^ first = second, it follows that val = first ^ second.
   Then, the question is essentially to find the leftmost binary substring
   in s such that its decimal value is equal to left ^ right.

2. Then we can preprocess s into a dictionary by enumerating all its substrings
   with length no greater than 32.
"""
from typing import *
from math import inf
import re
import random
import sys


class Solution:
    def substringXorQueries(self, s: str, queries: List[List[int]]) -> List[List[int]]:
        m = {}
        for i in reversed(range(len(s))):
            if s[i] == '0':
                m[0] = [i, i]
            else:
                j = i
                v = 0
                while j < len(s) and v <= 1000000000:
                    v = v * 2 + int(s[j])
                    m[v] = [i, j]
                    j += 1
        ans = []
        for left, right in queries:
            want = left ^ right
            ans.append(m.get(want, [-1, -1]))
        return ans

