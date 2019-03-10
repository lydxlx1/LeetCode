"""
LeetCode 1008 - Construct Binary Search Tree from Preorder Traversal

DFS
"""

from typing import *


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        if not preorder:
            return None
        root = TreeNode(preorder[0])
        root.left = self.bstFromPreorder([i for i in preorder if i < root.val])
        root.right = self.bstFromPreorder([i for i in preorder if i > root.val])
        return root
