"""
LeetCode 2549 - Count Distinct Numbers on Board

Math

It is easy to see x % (x - 1) is always equal to 1, when x >= 2.
In fact, x = (x - 1) + 1 = 1 mod (x - 1).

Therefore, when n >= 2, all integers from 2 to n will eventually
be written on the board, and 1 will never be there since
n % 1 = n >= 2.

Spacial case happens when n = 1, and it's easy to see the answer is 1.
"""
class Solution:
    def distinctIntegers(self, n: int) -> int:
        return 1 if n == 1 else n - 1
