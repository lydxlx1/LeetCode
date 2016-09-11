import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.junit.Assert.*;

public class _397Test {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void test1() {
        _397 sol = new _397();
        int actual = sol.integerReplacement(1);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        _397 sol = new _397();
        int actual = sol.integerReplacement(2);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        _397 sol = new _397();
        int actual = sol.integerReplacement(3);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        _397 sol = new _397();
        int actual = sol.integerReplacement(Integer.MAX_VALUE);
        int expected = 32;
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        _397 sol = new _397();
        int actual = sol.integerReplacement(8);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        _397 sol = new _397();
        int actual = sol.integerReplacement(7);
        int expected = 4;
        assertEquals(expected, actual);
    }
}