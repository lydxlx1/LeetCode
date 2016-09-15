import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _265Test {

    @Test
    public void test() throws Exception {
        _265 sol = new _265();
        int actual = sol.minCostII(new int[][]{{1, 3}, {2, 1}, {3, 1}});
        int expected = 5;
        assertEquals(expected, actual);
    }
}