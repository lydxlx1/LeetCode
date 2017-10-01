"""
LeetCode 687 - Longest Univalue Path

Tree DP
"""


class Solution:
    def longestUnivaluePath(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.ans = 0
        self.dfs(root)
        return self.ans

    def dfs(self, root):
        if root == None:
            return 0
        else:
            l = self.dfs(root.left)
            r = self.dfs(root.right)

            ll = l + 1 if root.left != None and root.val == root.left.val else 0
            rr = r + 1 if root.right != None and root.val == root.right.val else 0
            self.ans = max(self.ans, ll + rr)

            return max(ll, rr)