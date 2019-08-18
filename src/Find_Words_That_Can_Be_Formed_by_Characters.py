"""
Find Words That Can Be Formed by Characters

Brute-force
"""

from typing import *


class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        counter = Counter(chars)
        sum = 0
        for word in words:
            counter1 = Counter(word)
            good = True
            for ch, val in counter1.items():
                if ch not in counter or val > counter[ch]:
                    good = False
                    break
            if good:
                sum += len(word)

        return sum
