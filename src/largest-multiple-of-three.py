"""1363. Largest Multiple of Three

Math problem

We first have two facts that are easy to verify.
1. Since 10^x mod 3 = 1 (x >= 0), a number is a multiple of three if and only if the sum of digits is a multiple of three.
2. When the set of digits is given, to gain the max value, we should concatenate them in decreasing order.
   And if the largest digit is zero (no matter how many zeros are there), the answer is also zero.
   If the set of digit is empty, we output empty string.
   
   
Then, it is easier to solve this problem backwards, i.e.,
considering the digits we have to discard to make the final number as large as possible.

Sum up all the digits and we have three cases based on its modulo (by 3).
1. mod = 0. This is a happy case, and we should just use up all the digits.
2. mod = 1. We should either discard a digit (that is 1 mod 3) or discard two digits (that is 2 mod 3).
3. mod = 2.

Time: O(n log n), which can be optimized to O(n) using counting sort.
Space: O(n)
"""
from typing import List
from collections import defaultdict


class Solution:
    def largestMultipleOfThree(self, digits: List[int]) -> str:
        mod3 = defaultdict(list)
        for d in sorted(digits)[::-1]:
            mod3[d % 3].append(d)
        total = sum(digits)
        if total % 3 == 1:
            if mod3[1]:
                mod3[1].pop()
            elif len(mod3[2]) >= 2:
                mod3[2].pop()
                mod3[2].pop()
            else:
                return ""
        elif total % 3 == 2:
            if mod3[2]:
                mod3[2].pop()
            elif len(mod3[1]) >= 2:
                mod3[1].pop()
                mod3[1].pop()
            else:
                return ""

        candidates = sorted(mod3[0] + mod3[1] + mod3[2])[::-1]
        if candidates:
            if candidates[0] == 0:
                return "0"
            else:
                return "".join(str(i) for i in candidates)
        else:
            return ""
