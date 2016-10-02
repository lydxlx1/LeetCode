import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _410Test {

    @Test
    public void test() throws Exception {
        _410 sol = new _410();
        assertEquals(9, sol.splitArray(new int[]{1, 2, 3, 4, 5}, 2));
        assertEquals(15, sol.splitArray(new int[]{5, 5, 5}, 1));
        assertEquals(10, sol.splitArray(new int[]{5, 5, 5}, 2));
        assertEquals(5, sol.splitArray(new int[]{5, 5, 5}, 3));
        assertEquals(2147483647, sol.splitArray(new int[]{1, 2147483647}, 2));
    }
}


