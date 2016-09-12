import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static junit.framework.TestCase.assertEquals;

public class _270Test {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void test() throws Exception {
        _270 sol = new _270();
        TreeNode node = Deserializer.deserializeTreeNode(new Integer[]{1});
        int actual = sol.closestValue(node, 0.5);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void test1() throws Exception {
        _270 sol = new _270();
        TreeNode node = Deserializer.deserializeTreeNode(new Integer[]{2, 1, 3});
        int actual = sol.closestValue(node, 1);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void test2() throws Exception {
        _270 sol = new _270();
        TreeNode node = Deserializer.deserializeTreeNode(new Integer[]{2, 1, 3});
        int actual = sol.closestValue(node, 1.6);
        int expected = 2;
        assertEquals(expected, actual);
    }
}