from typing import *


class Solution:
    def findOcurrences(self, text: str, first: str, second: str) -> List[str]:
        ans = []
        a, b, c = '', '', ''
        for i in text.split(' '):
            a, b, c = b, c, i
            if a == first and b == second:
                ans.append(c)
        return ans
