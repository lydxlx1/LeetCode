import java.util.StringJoiner;

/**
 * LeetCode 572 - Subtree of Another Tree
 * <p>
 * Tree encoding solution, which is somewhat elegant...
 */
public class _572_2 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringJoiner sJoiner = new StringJoiner(",");
        StringJoiner tJoiner = new StringJoiner(",");
        toString(s, sJoiner);
        toString(t, tJoiner);
        return sJoiner.toString().contains(tJoiner.toString());
    }

    private void toString(TreeNode s, StringJoiner joiner) {
        if (s == null) {
            joiner.add("#");
            return;
        }
        joiner.add("" + s.val);
        toString(s.left, joiner);
        toString(s.right, joiner);
    }
}
