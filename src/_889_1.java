import java.util.Arrays;

/**
 * LeetCode 889 - Construct Binary Tree from Preorder and Postorder Traversal
 * <p>
 * Easy version
 * <p>
 * Since the problem has given the following two conditions:
 * <p>
 * - pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * - It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 * <p>
 * the output exists and is unique.
 */
public class _889_1 {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) return null;
        TreeNode node = new TreeNode(pre[0]);
        if (pre.length > 1) {
            int leftChildSize = 0, n = pre.length;
            for (int i : post) {
                leftChildSize++;
                if (i == pre[1]) {
                    break;
                }
            }
            node.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, 1 + leftChildSize), Arrays.copyOfRange(post, 0, leftChildSize));
            node.right = constructFromPrePost(Arrays.copyOfRange(pre, 1 + leftChildSize, n), Arrays.copyOfRange(post, leftChildSize, n - 1));
        }
        return node;
    }
}

