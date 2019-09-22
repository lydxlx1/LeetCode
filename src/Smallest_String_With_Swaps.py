"""Smallest String With Swaps

Union-Find Set + Sorting"""

from typing import *
from collections import *


class Solution:
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
        n = len(s)
        parent = list(range(n))

        def find(i: int) -> int:
            if i != parent[i]:
                parent[i] = find(parent[i])
            return parent[i]

        def union(i: int, j: int):
            parent[find(i)] = find(j)

        for u, v in pairs:
            union(u, v)

        extracted = defaultdict(str)
        for i in range(n):
            extracted[find(i)] += s[i]
        extracted = {k: sorted(v)[::-1] for k, v in extracted.items()}  # reverse to support O(1) time pop.
        return "".join(extracted[find(i)].pop() for i in range(n))
