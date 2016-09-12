import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.junit.Assert.assertEquals;

public class _333Test {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void test() throws Exception {
        _333 sol = new _333();
        TreeNode root = Deserializer.deserializeTreeNode(new Integer[]{10, 5, 15, 1, 8, null, 7});
        int actual = sol.largestBSTSubtree(root);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void test1() throws Exception {
        _333 sol = new _333();
        TreeNode root = Deserializer.deserializeTreeNode(new Integer[]{});
        int actual = sol.largestBSTSubtree(root);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void test2() throws Exception {
        _333 sol = new _333();
        TreeNode root = Deserializer.deserializeTreeNode(new Integer[]{2, 1, 3, 0});
        int actual = sol.largestBSTSubtree(root);
        int expected = 4;
        assertEquals(expected, actual);
    }
}