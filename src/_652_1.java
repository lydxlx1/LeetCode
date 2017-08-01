import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 652 - Find Duplicate Subtrees
 * <p>
 * Binary Tree Encoding
 */
public class _652_1 {

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();


    private String dfs(TreeNode root) {
        if (root == null)
            return "#";
        else {
            String s = root.val + "," + dfs(root.left) + "," + dfs(root.right);
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (map.get(s) == 2) {
                res.add(root);
            }
            return s;
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    public static void main(String[] args) {
        _652_1 sol = new _652_1();
        TreeNode a = new TreeNode(2);
        a.left = new TreeNode(1);
        a.right = new TreeNode(1);
        System.out.println(sol.findDuplicateSubtrees(a));
    }
}
