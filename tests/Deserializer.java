public class Deserializer {
    public static TreeNode deserializeTreeNode(Integer[] values) {
        if (values.length == 0) return null;
        TreeNode[] nodes = new TreeNode[values.length];
        for (int i = 0; i < values.length; i++) nodes[i] = values[i] == null ? null : new TreeNode(values[i]);
        for (int i = 0, j = i + 1; i < values.length && j < values.length; i++)
            if (nodes[i] != null) {
                if (j < values.length) nodes[i].left = nodes[j++];
                if (j < values.length) nodes[i].right = nodes[j++];
            }
        return nodes[0];
    }

    public static ListNode deserializeListNode(Integer[] values) {
        ListNode header = new ListNode(0), ptr = header;
        for (int value : values) {
            ptr.next = new ListNode(value);
            ptr = ptr.next;
        }
        return header.next;
    }

    private static void dfs(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}