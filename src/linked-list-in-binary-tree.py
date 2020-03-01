"""1367. Linked List in Binary Tree

It is hard to solve the problem in a top-down fashion since each tree node can have two choices.
However, since each node has a unique parent, the upwards paths ending at any node are also unique (by its length).
This suggests a DFS approach, where we just need to check whether the last m nodes on the stack match the given listed list at any time.

Time: O(mn)
Space: O(m + h)
m = linked list size, n = binary tree size, h = binary tree height
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isSubPath(self, head: ListNode, root: TreeNode) -> bool:
        target = []
        while head:
            target.append(head.val)
            head = head.next

        def dfs(root, path):
            if len(path) >= len(target) and path[-len(target):] == target:
                return True
            if not root:
                return False
            path.append(root.val)
            if dfs(root.left, path) or dfs(root.right, path):
                return True
            path.pop()
            return False
        return dfs(root, [])
