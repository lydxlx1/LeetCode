"""Remove All Adjacent Duplicates in String II

Stack
"""

from typing import *
from collections import *


class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        ans = []
        for ch in s:
            cnt = ans[-1][1] + 1 if ans and ans[-1][0] == ch else 1
            ans.append([ch, cnt])

            if ans[-1][1] >= k:
                for _ in range(k):
                    ans.pop()

        return "".join(ch for ch, _ in ans)
