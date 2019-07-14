"""
Lowest Common Ancestor of Deepest Leaves

Tree-DP
"""


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lcaDeepestLeaves(self, root: TreeNode) -> TreeNode:

        def dfs(root: TreeNode):
            if not root:
                return None, 0

            left, left_height = dfs(root.left)
            right, right_height = dfs(root.right)

            if left_height < right_height:
                return right, right_height + 1
            elif left_height == right_height:
                return root, right_height + 1
            else:
                return left, left_height + 1

        return dfs(root)[0]
