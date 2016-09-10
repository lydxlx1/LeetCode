public class Deserializer {
    public static TreeNode deserialize(Integer[] values) {
        if (values.length == 0) return null;
        TreeNode[] nodes = new TreeNode[values.length];
        for (int i = 0; i < values.length; i++) nodes[i] = values[i] == null ? null : new TreeNode(values[i]);
        int pre = 0;
        for (int i = 0, j = i + 1; i < values.length && j < values.length; i++)
            if (nodes[i] != null) {
                if (j < values.length) nodes[i].left = nodes[j++];
                if (j < values.length) nodes[i].right = nodes[j++];
            }
        return nodes[0];
    }

    private static void dfs(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = deserialize(new Integer[]{3,9,8,4,0,1,7,null,null,null,2,5});
        dfs(root);
    }
}