"""1366. Rank Teams by Votes

Radix Sort
Assume there are m rounds of voting, we can solve this problem by a radix sort (from the m-th round to the first round).

Time: O(m * (26 log 26)), which can be further optimized to O(26m) using counting sort.
Space: O(26)
"""
from collections import Counter
from typing import List


class Solution:
    def rankTeams(self, votes: List[str]) -> str:
        a = sorted(list(votes[0]))
        for col in range(len(votes[0]) - 1, -1, -1):
            cnt = Counter(vote[col] for vote in votes)
            a.sort(key=lambda ch: -cnt[ch])
        return "".join(a)
