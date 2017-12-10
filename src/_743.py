"""
LeetCode 743 - Network Delay Time

Floyd
"""


class Solution:
    def networkDelayTime(self, times, N, K):
        """
        :type times: List[List[int]]
        :type N: int
        :type K: int
        :rtype: int
        """
        inf = 1 << 29
        d = [[inf] * N for i in range(N)]
        for i in range(N):
            d[i][i] = 0
        for (u, v, w) in times:
            d[u - 1][v - 1] = min(d[u - 1][v - 1], w)

        for k in range(N):
            for i in range(N):
                for j in range(N):
                    d[i][j] = min(d[i][j], d[i][k] + d[k][j])

        ans = max(d[K - 1])
        return ans if ans < inf else -1
