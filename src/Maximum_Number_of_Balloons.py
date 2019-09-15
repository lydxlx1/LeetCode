"""Maximum Number of Balloons"""
from typing import *
from collections import *


class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        counter = Counter(text)
        balloon = Counter("balloon")
        ans = 1 << 29
        for k, v in balloon.items():
            ans = min(ans, counter[k] // v)
        return ans
