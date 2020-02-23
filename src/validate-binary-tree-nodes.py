"""1361. Validate Binary Tree Nodes

There are multiple ways to validate a binary tree. Here is one way of doing that.
- There must be exactly n - 1 edges.
- There must be exactly one node with 0 in-degree, and that node is the root.
- Every other node must have in-degree equal to one.

Time: O(n)
Space: O(n)
"""

from typing import List


class Solution:
    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        root = set(range(n)) - set(leftChild) - set(rightChild)
        if len(root) != 1:
            return False

        visited = set()

        def dfs(root: int) -> bool:
            if root == -1:
                return True
            if root in visited:
                return False
            visited.add(root)
            return dfs(leftChild[root]) and dfs(rightChild[root])

        return dfs(next(iter(root))) and len(visited) == n
