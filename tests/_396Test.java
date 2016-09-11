import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.junit.Assert.*;

public class _396Test {
    private _396 sol = new _396();

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void test1() throws Exception {
        int[] a = {4, 3, 2, 6};
        int actual = sol.maxRotateFunction(a);
        int expected = 26;
        assertEquals(expected, actual);
    }

    @Test
    public void test2() throws Exception {
        int[] a = {0};
        int actual = sol.maxRotateFunction(a);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testOverflow() throws Exception {
        int[] a = {-Integer.MIN_VALUE, -Integer.MIN_VALUE};
        int actual = sol.maxRotateFunction(a);
        int expected = -Integer.MIN_VALUE;
        assertEquals(expected, actual);
    }
}