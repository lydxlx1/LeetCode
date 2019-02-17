"""
LeetCode 993 - Cousins in Binary Tree
"""
class Solution:
    def isCousins(self, root: 'TreeNode', x: 'int', y: 'int') -> 'bool':

        def dfs(root, parent, d, x):
            if root is None:
                return None
            if root.val == x:
                return (parent, d)
            return dfs(root.left, root, d + 1, x) or dfs(root.right, root, d + 1, x)

        (p1, d1) = dfs(root, None, 0, x)
        (p2, d2) = dfs(root, None, 0, y)

        return x != y and p1 != p2 and d1 == d2

        