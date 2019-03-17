"""
LeetCode 1015 -  Numbers With Repeated Digits

Digit + Mask DP
"""


class Solution:
    def numDupDigitsAtMostN(self, N: int) -> int:
        def f(t, free_flag, mask, memo, n):
            key = (t, free_flag, mask)
            if key in memo:
                return memo[key]
            if t >= len(n):
                return 1

            cnt = 0
            upper = 10 if free_flag else n[t] + 1
            for i in range(upper):
                if t == 0 and i == 0:  # First digit cannot be zero.
                    continue
                if ((1 << i) & mask) == 0:
                    new_free_flag = free_flag or i < n[t]
                    cnt += f(t + 1, new_free_flag, mask | (1 << i), memo, n)

            memo[key] = cnt
            return cnt

        complement = 0
        for i in range(20):
            if 10 ** i - 1 < N:
                complement += f(0, False, 0, {}, [ord(j) - ord('0') for j in str(10 ** i - 1)])
            else:
                break
        complement += f(0, False, 0, {}, [ord(i) - ord('0') for i in str(N)])
        return N - complement
