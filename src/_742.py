"""
LeetCode 742 - Closest Leaf in a Binary Tree

O(n)-time solution
1. For each node, determine whether it is a leaf.
2. Let k be the new root and reconstruct the tree.
3. Do a dfs on the new tree and find the leaf (in the original tree) with the shortest distance.
"""
from collections import defaultdict


class Solution:
    def findClosestLeaf(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        is_leaf = [False] * 1001
        edges = defaultdict(list)

        def add(u, v):
            if u and v:
                edges[u.val].append(v.val)
                edges[v.val].append(u.val)

        def dfs(root, parent):
            add(root, parent)
            if root:
                is_leaf[root.val] = not root.left and not root.right
                dfs(root.left, root)
                dfs(root.right, root)

        dfs(root, None)

        def dfs1(root, parent, dist):
            res = (1 << 29, -1)
            if is_leaf[root]:
                res = (dist, root)
            for ch in edges[root]:
                if ch != parent:
                    res = min(res, dfs1(ch, root, dist + 1))
            return res

        return dfs1(k, -1, 0)[1]
