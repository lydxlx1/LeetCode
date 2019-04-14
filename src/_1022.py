"""
LeetCode 1022 - Sum of Root To Leaf Binary Numbers

DFS
"""


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def sumRootToLeaf(self, root: TreeNode) -> int:

        def dfs(root: TreeNode, previous: int) -> int:
            current = previous * 2 + root.val
            ans = 0
            if not root.left and not root.right:
                ans += current
            if root.left:
                ans += dfs(root.left, current)
            if root.right:
                ans += dfs(root.right, current)
            return ans

        return dfs(root, 0)
