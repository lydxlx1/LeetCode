"""Number of Valid Words for Each Puzzle

Bit Manipulation

1. Only anagram matters in this problem.
2. We can represent each anagram in binary representation as (1 << 26) fits in memory.
  a. Initializing a list of size 1 << 26 takes a quite long time in Python, so I choose to use a dict instead.
3. We can throw away any anagrams (w.r.t words) that has length > 7.
  a. Then, the total dict size cannot exceed (26 choose 7) = 657800, which is fairly small.
4. For each query, we can brute-force all the matches. As the first letter must present, we only need to enumerate
   2^6 = 64 choices.
"""
from typing import *
from collections import *


class Solution:
    def findNumOfValidWords(self, words: List[str], puzzles: List[str]) -> List[int]:
        cnt = Counter()
        for word in words:
            mask = 0
            for ch in word:
                mask |= 1 << (ord(ch) - ord('a'))
            cnt[mask] += 1

        ans = []
        for puzzle in puzzles:
            local_cnt = 0
            first_letter = 1 << (ord(puzzle[0]) - ord('a'))

            for mask in range(1 << 6):
                big_mask = 0
                for i in range(6):
                    if (1 << i) & mask:
                        big_mask |= 1 << (ord(puzzle[1 + i]) - ord('a'))  # Starting from the second letter
                local_cnt += cnt[first_letter | big_mask]
            ans.append(local_cnt)
        return ans
