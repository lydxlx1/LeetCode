"""
LeetCode 834 - Sum of Distances in Tree

Tree DP
- Compute the dist sum for some node (say node 0) via brute-force.
- Then do a tree traversal, when I walk from a node to another, compute the result for the node
  in O(1) time.

"""


class Solution:
    def sumOfDistancesInTree(self, N, edges):
        """
        :type N: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """

        self.N = N
        self.tree = [[] for i in range(N)]
        for u, v in edges:
            self.tree[u].append(v)
            self.tree[v].append(u)

        self.size = [0] * N
        self.dfs(0, -1)  # Compute the size of each subtree.

        self.ans = [0] * N
        ans_0 = self.dfs1(0, -1, 0)  # Compute the answer for root node 0.
        self.dfs2(0, -1, ans_0)

        return self.ans

    def dfs(self, root, parent):
        self.size[root] = 1
        for child in self.tree[root]:
            if child != parent:
                self.size[root] += self.dfs(child, root)
        return self.size[root]

    def dfs1(self, root, parent, depth):
        res = depth
        for child in self.tree[root]:
            if child != parent:
                res += self.dfs1(child, root, depth + 1)
        return res

    def dfs2(self, root, parent, dist_sum):
        self.ans[root] = dist_sum
        for child in self.tree[root]:
            if child != parent:
                self.dfs2(child, root, dist_sum + (self.N - self.size[child]) - self.size[child])
