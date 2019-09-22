"""Sort Items by Groups Respecting Dependencies

Topological sort (twice)"""
from typing import *


class Graph:

    def __init__(self, n: int):
        self.n = n
        self.out_edges = [[] for _ in range(n)]
        self.in_degree = [0] * n

    def add_edge(self, u: int, v: int):
        self.out_edges[u].append(v)
        self.in_degree[v] += 1

    def topological_sort(self) -> List[int]:
        n = self.n
        in_degree = self.in_degree.copy()
        out_edges = self.out_edges
        queue = [i for i in range(n) if in_degree[i] == 0]
        ptr = 0
        while ptr < len(queue):
            u = queue[ptr]
            ptr += 1
            for v in out_edges[u]:
                in_degree[v] -= 1
                if in_degree[v] == 0:
                    queue.append(v)
        return queue


class Solution:
    def sortItems(self, n: int, m: int, group: List[int], beforeItems: List[List[int]]) -> List[int]:

        # First topological sort on items
        g = Graph(n)
        for i in range(n):
            for pre in beforeItems[i]:
                g.add_edge(pre, i)
        order = g.topological_sort()
        if len(order) < n:
            return []

        # Now, topological sort on groups
        for i in range(n):
            if group[i] == -1:
                group[i] = m
                m += 1

        grouped_items = [[] for i in range(m)]
        for i in order:
            grouped_items[group[i]].append(i)
        g = Graph(m)
        for i in range(n):
            for pre in beforeItems[i]:
                if group[pre] != group[i]:
                    g.add_edge(group[pre], group[i])
        order = g.topological_sort()
        if len(order) < m:
            return []
        return [item for i in order for item in grouped_items[i]]
