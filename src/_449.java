import java.util.StringJoiner;

/**
 * LeetCode 449 - Serialize and Deserialize BST
 * <p>
 * Assume all keys stores in the BST are distinct.
 * Then, given any ordered traversal sequence, one can reconstruct the original BST.
 * <p>
 * In this implementation, the deserializer looks simple and clean but has an O(n^2) worst-case runtime.
 * We will improve it in the next submission.
 */
public class _449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        final StringJoiner joiner = new StringJoiner(" ");
        class Serializer {
            public void dfs(TreeNode root) {
                if (root == null) return;
                joiner.add("" + root.val);
                dfs(root.left);
                dfs(root.right);
            }
        }
        new Serializer().dfs(root);
        return joiner.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.trim();
        if (data.length() <= 0) return null;

        String[] tokens = data.trim().split(" ");
        int[] values = new int[tokens.length];

        class Deserializer {
            public TreeNode dfs(int l, int r) {
                if (l > r) return null;
                TreeNode root = new TreeNode(values[l]);
                int leftChildEnd = l; // inclusive
                for (int i = l + 1; i <= r; i++)
                    if (values[i] < root.val) leftChildEnd = i;
                    else break;
                root.left = dfs(l + 1, leftChildEnd);
                root.right = dfs(leftChildEnd + 1, r);
                return root;
            }
        }

        for (int i = 0; i < values.length; i++)
            values[i] = Integer.parseInt(tokens[i]);
        return new Deserializer().dfs(0, values.length - 1);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));