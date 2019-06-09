"""
Smallest Subsequence of Distinct Characters

Linear time Greedy solution using a stack
"""
from collections import *
from typing import *


class Solution:
    def smallestSubsequence(self, text: str) -> str:
        right_counter = Counter(text)
        left_counter = Counter('')
        ans = []
        for i in range(len(text)):
            ch = text[i]
            right_counter[ch] -= 1
            # Skip this letter is it is already a part of current solution
            if left_counter[ch] > 0:
                continue

            # We pop the top of the stack if
            #
            # (i) if the current letter (ch) is smaller than the top of stack (hence popping the top and replacing the
            # top with ch will yield better result), and
            #
            # (ii) it is safe to remove the top element, i.e., the same letter will appear at least once afterwards.
            while len(ans) > 0 and ans[-1] > ch and right_counter[ans[-1]] > 0:
                left_counter[ans[-1]] -= 1
                ans.pop(-1)
            ans.append(ch)
            left_counter[ch] += 1
        return ''.join(ans)
