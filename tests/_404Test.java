import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _404Test {

    @Test
    public void test() throws Exception {
        _404 sol = new _404();
        assertEquals(24, sol.sumOfLeftLeaves(Deserializer.deserializeTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
        assertEquals(0, sol.sumOfLeftLeaves(Deserializer.deserializeTreeNode(new Integer[]{})));
        assertEquals(0, sol.sumOfLeftLeaves(Deserializer.deserializeTreeNode(new Integer[]{100})));
    }
}