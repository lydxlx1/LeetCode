"""
LeetCode 743 - Network Delay Time

SPFA
"""

from collections import OrderedDict

"""
LeetCode 743 - Network Delay Time

Floyed
"""

from collections import deque


class Solution:
    def networkDelayTime(self, times, N, K):
        """
        :type times: List[List[int]]
        :type N: int
        :type K: int
        :rtype: int
        """
        inf = 1 << 29
        d = [inf] * N
        in_queue = [False] * N
        edges = [[] for i in range(N)]
        for u, v, w in times:
            edges[u - 1].append((v - 1, w))

        queue = OrderedDict()
        queue[K - 1] = K - 1
        d[K - 1] = 0
        while len(queue) > 0:
            u = queue.popitem()[0]
            for v, w in edges[u]:
                if d[u] + w < d[v]:
                    d[v] = d[u] + w
                    if v not in queue:
                        queue[v] = v

        return max(d) if max(d) < inf else -1
