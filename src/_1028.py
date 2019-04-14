"""
LeetCode 1028 - Recover a Tree From Preorder Traversal

Using a stack
Note that "If a node has only one child, that child is guaranteed to be the left child."
"""

from typing import *


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def recoverFromPreorder(self, S: str) -> TreeNode:
        self.ptr = 0

        def read() -> Tuple[int, int]:
            d, num = 0, 0
            while self.ptr < len(S) and S[self.ptr] == '-':
                d += 1
                self.ptr += 1
            while self.ptr < len(S) and S[self.ptr].isdigit():
                num = num * 10 + int(S[self.ptr])
                self.ptr += 1
            return d, num

        root = TreeNode(read()[1])
        stack = [(0, root)]
        while self.ptr < len(S):
            d, num = read()
            node = TreeNode(num)
            while stack[-1][0] >= d:
                stack.pop()
            parent = stack[-1][1]
            if parent.left is None:
                parent.left = node
            else:
                parent.right = node
            stack.append((d, node))

        return root
