""" Get Equal Substrings Within Budget

Sliding Window"""


class Solution:
    def equalSubstring(self, s: str, t: str, max_cost: int) -> int:
        max_len = 0
        l = 0
        cost = 0
        for r in range(len(s)):
            cost += abs(ord(s[r]) - ord(t[r]))
            while l <= r and cost > max_cost:
                cost -= abs(ord(s[l]) - ord(t[l]))
                l += 1
            max_len = max(max_len, r - l + 1)

        return max_len
