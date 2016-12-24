import java.util.Arrays;
import java.util.StringJoiner;

/**
 * LeetCode 449 - Serialize and Deserialize BST
 * <p>
 * An optimized version
 * O(n) - Serialize
 * O(n log n) - Deserialize
 */
public class _449_1 {

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
        int[] preOrder = new int[tokens.length];
        for (int i = 0; i < preOrder.length; i++)
            preOrder[i] = Integer.parseInt(tokens[i]);
        int[] inOrder = preOrder.clone();
        Arrays.sort(inOrder);

        class Deserializer {
            public TreeNode dfs(int preL, int preR, int inL, int inR) {
                if (preR - preL != inR - inL)
                    throw new IllegalStateException("Inconsistent preorder and inorder sequences.");
                if (preL > preR) return null;
                TreeNode root = new TreeNode(preOrder[preL]);

                int left = inL, right = inR;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (inOrder[mid] == root.val) {
                        int leftChildSize = mid - inL;
                        root.left = dfs(preL + 1, preL + leftChildSize, inL, mid - 1);
                        root.right = dfs(preL + leftChildSize + 1, preR, mid + 1, inR);
                        return root;
                    } else if (inOrder[mid] < root.val) left = mid + 1;
                    else right = mid - 1;
                }
                throw new IllegalStateException("Inconsistent preorder and inorder sequences.");
            }
        }
        return new Deserializer().dfs(0, preOrder.length - 1, 0, inOrder.length - 1);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));