"""
Binary Tree Coloring Game

Optimal solution must be one of the following choices
- x's parent, then the second player can get everything except the subtree rooted at x
- x's left child, then the second player can get everything in the subtree rooted at x's left child
- x's right child, then the second player can get everything in the subtree rooted at x's right child

(I feel it's very handy to code this problem in Python as I can arbitrary inject new fields in the TreeNode definition.)
"""
from typing import *


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def btreeGameWinningMove(self, root: TreeNode, n: int, x: int) -> bool:

        def dfs(root, p):
            if not root:
                return 0
            root.parent = p
            root.size = 1
            root.size += dfs(root.left, root)
            root.size += dfs(root.right, root)
            if root.val == x:
                self.x = root
            return root.size

        dfs(root, None)

        x = self.x
        if x.parent:
            if root.size - x.size > x.size:
                return True
        if x.left and x.left.size > root.size - x.left.size:
            return True
        if x.right and x.right.size > root.size - x.right.size:
            return True
        return False
