"""
Longest Chunked Palindrome Decomposition

DP

Couldn't understand why this problem is marked as hard...
"""


class Solution:
    def longestDecomposition(self, text: str) -> int:

        def f(s, memo):
            if len(s) <= 1:
                return len(s)
            if s in memo:
                return memo[s]
            ans = 1
            for i in range(1, len(s)):
                if s[0:i] == s[len(s) - i:len(s)]:
                    ans = max(ans, 2 + f(s[i:len(s) - i], memo))
            memo[s] = ans
            return ans

        return f(text, {})
