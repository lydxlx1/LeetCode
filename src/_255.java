/**
 * LeetCode 255 - Verify Preorder Sequence in Binary Search Tree
 *
 * Construction method
 * O(n) space & time
 *
 * For a Binary Search Tree (with unique keys), given its pre-order/in-order/post-order traversal,
 * it is sufficient to reconstruct the original tree.
 */
public class _255 {
    static class Tree {
        int val, begin, end;
        Tree left, right, parent;

        public Tree(int val, int begin, int end) {
            this.val = val;
            this.begin = begin;
            this.end = end;
        }
    }

    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length == 0) return true;
        Tree root = new Tree(preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
        for (int i = 1; i < preorder.length; ) {
            if (root.begin < preorder[i] && preorder[i] < root.val) {
                if (root.left != null || root.right != null) return false; // If we visit the left branch, make sure it is done before visiting the right one
                Tree ch = new Tree(preorder[i++], root.begin, root.val);
                root.left = ch;
                ch.parent = root;
                root = ch;
            } else if (root.val < preorder[i] && preorder[i] < root.end) {
                if (root.right != null) return false;
                Tree ch = new Tree(preorder[i++], root.val, root.end);
                root.right = ch;
                ch.parent = root;
                root = ch;
            } else {
                if (root.parent == null) return false;
                root = root.parent;
            }
        }
        return true;
    }
}