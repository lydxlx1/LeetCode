import java.util.*;

/**
 * LeetCode 297 - Serialize and Deserialize Binary Tree
 * <p>
 * via DFS
 */
public class _297 {

    private void dfs(TreeNode root, List<String> list) {
        if (root == null) list.add("null");
        else {
            list.add("" + root.val);
            dfs(root.left, list);
            dfs(root.right, list);
        }
    }

    private TreeNode dfs(Deque<String> queue) {
        String str = queue.pollFirst();
        if (str.equals("null")) return null;
        else {
            TreeNode node = new TreeNode(Integer.parseInt(str));
            node.left = dfs(queue);
            node.right = dfs(queue);
            return node;
        }
    }

    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, list);
        return String.join(",", list);
    }

    public TreeNode deserialize(String data) {
        return dfs(new ArrayDeque<>(Arrays.asList(data.split(","))));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}