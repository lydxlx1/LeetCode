"""1382. Balance a Binary Search Tree

Do an in-order traversal to obtain all the elements in BST in sorted order.
Then build the balanced tree using Divide-and-Conquer.
"""


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def balanceBST(self, root: TreeNode) -> TreeNode:
        sorted_tree = []

        def in_order(root):
            if not root:
                return
            in_order(root.left)
            sorted_tree.append(root.val)
            in_order(root.right)

        in_order(root)

        def build(l, r):
            if l > r:
                return None
            mid = (l + r) // 2
            root = TreeNode(sorted_tree[mid])
            root.left = build(l, mid - 1)
            root.right = build(mid + 1, r)
            return root

        return build(0, len(sorted_tree) - 1)
