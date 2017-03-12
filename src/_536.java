/**
 * LeetCode 536 - Construct Binary Tree from String
 * <p>
 * LL(1)-parser
 */
public class _536 {
    public TreeNode str2tree(String s) {
        if (s.equals("")) return null;
        ptr = 0;
        return dfs(s);
    }

    private int ptr;

    private TreeNode dfs(String s) {
        long num = 0, sign = 1;
        if (s.charAt(ptr) == '-') {
            sign = -1;
            ptr++;
        }
        while (ptr < s.length() && Character.isDigit(s.charAt(ptr)))
            num = num * 10 + s.charAt(ptr++) - '0';
        TreeNode root = new TreeNode((int) (num * sign));
        if (ptr < s.length() && s.charAt(ptr) == '(') {
            ptr++;
            root.left = dfs(s);
            ptr++;
        }
        if (ptr < s.length() && s.charAt(ptr) == '(') {
            ptr++;
            root.right = dfs(s);
            ptr++;
        }
        return root;
    }
}
