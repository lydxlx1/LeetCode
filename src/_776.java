import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 776 - Split BST
 * <p>
 * This is a common operation used in Treap
 */
public class _776 {

    public TreeNode[] splitBST(TreeNode root, int V) {
        List<TreeNode> one = new ArrayList<>();
        List<TreeNode> two = new ArrayList<>();

        while (root != null) {
            if (root.val <= V) {
                one.add(root);
                root = root.right;
            } else {
                two.add(root);
                root = root.left;
            }
        }

        one.add(null);
        two.add(null);

        for (int i = one.size() - 2; i >= 0; i--) {
            one.get(i).right = one.get(i + 1);
        }
        for (int i = two.size() - 2; i >= 0; i--) {
            two.get(i).left = two.get(i + 1);
        }
        return new TreeNode[]{one.get(0), two.get(0)};
    }
}



