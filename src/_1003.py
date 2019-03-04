"""
LeetCode 1002 - Check If Word Is Valid After Substitutions
"""
from sys import *
from typing import *
from collections import *
from string import *


class Solution:
    def isValid(self, S: str) -> bool:
        s = []
        for ch in S:
            if ch == 'a':
                s += ch
            elif ch == 'b':
                if not s or s[-1] != 'a':
                    return False
                s += ch
            else:
                if not s or s[-1] != 'b':
                    return False
                s.pop(-1)
                s.pop(-1)
        return not s