"""Critical Connections in a Network

DFS to find bridges"""
from typing import *


class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        bridges = []

        # Build the graph
        g = [[] for _ in range(n)]
        for (u, v) in connections:
            g[u].append(v)
            g[v].append(u)

        depth = [None] * n

        def dfs(u: int, parent: int, d: int):
            depth[u] = d

            min_back_edge_depth = d
            for v in g[u]:
                if depth[v] is None:
                    tmp = dfs(v, u, d + 1)
                    if tmp == depth[v]:
                        bridges.append([u, v])
                    min_back_edge_depth = min(min_back_edge_depth, tmp)
                elif v != parent:  # Need to skip the edge between u and its parent as this is NOT a backwards cycle.
                    min_back_edge_depth = min(min_back_edge_depth, depth[v])
            return min_back_edge_depth

        for i in range(n):
            if depth[i] is None:
                dfs(i, None, 0)

        return bridges
