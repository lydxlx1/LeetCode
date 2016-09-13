import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _96Test {

    @Test
    public void test() throws Exception {
        _96 sol = new _96();
        assertEquals(1, sol.numTrees(0));
        assertEquals(1, sol.numTrees(1));
        assertEquals(2, sol.numTrees(2));
        assertEquals(5, sol.numTrees(3));
    }
}