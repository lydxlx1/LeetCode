"""
Maximum Level Sum of a Binary Tree

DFS
"""

from collections import *


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def maxLevelSum(self, root: TreeNode) -> int:
        level_sum = defaultdict(int)

        def dfs(root: TreeNode, level: int):
            if not root:
                return
            level_sum[level] += root.val
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)

        dfs(root, 1)
        return -max([(sum, -level) for level, sum in level_sum.items()])[1]
