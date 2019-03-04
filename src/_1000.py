"""
LeetCode 1000 - Minimum Cost to Merge Stones

DP
Let f[i, j, k] denote the minimum cost to merge stones[i..j] into exactly k piles.
Two cases are relatively trick and deserve more attention.
(i)  when k == 1
(ii) when j - i + 1 == k
"""
from sys import *
from typing import *
from collections import *
from string import *
from itertools import *


class Solution:
    def mergeStones(self, stones: List[int], K: int) -> int:
        n = len(stones)
        inf = 1 << 28
        sum = list(accumulate(stones))

        memo = {}

        def f(l, r, piles):
            if r - l + 1 == piles:  # keep them
                return 0
            if r - l + 1 < piles:
                return inf
            if (l, r, piles) in memo:
                return memo[l, r, piles]

            res = inf
            if piles == 1:
                # The case when l == r has already been considered above.
                # In this case, we want to merge more than 1 stones into one piles.
                # Then, we have to recursively merge them into K piles first, then conduct a final merge.
                res = f(l, r, K) + sum[r] - (sum[l - 1] if l - 1 >= 0 else 0)
            else:
                for mid in range(l, r):
                    res = min(res, f(l, mid, 1) + f(mid + 1, r, piles - 1))

            memo[l, r, piles] = res
            return res

        ans = f(0, n - 1, 1)
        return ans if ans < inf else -1
