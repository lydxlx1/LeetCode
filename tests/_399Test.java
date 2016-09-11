import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.junit.Assert.*;

public class _399Test {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void test() throws Exception {
        _399 sol = new _399();
        String[][] e = {{"a", "b"}, {"b", "c"}};
        double[] v = {2.0, 3.0};
        String[][] q = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double[] actual = sol.calcEquation(e, v, q);
        double[] expected = {6, 0.5, -1, 1, -1};
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++)
            assertTrue(Double.compare(expected[i], actual[i]) == 0);
    }

    @Test
    public void test1() throws Exception {
        _399 sol = new _399();
        String[][] e = {{"a", "b"}, {"c", "d"}};
        double[] v = {2.0, 3.0};
        String[][] q = {{"a", "a"}, {"b", "b"}, {"a", "b"}, {"b", "a"}, {"a", "c"}, {"c", "a"}};
        double[] actual = sol.calcEquation(e, v, q);
        double[] expected = {1, 1, 2, 0.5, -1, -1};
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++)
            assertTrue(Double.compare(expected[i], actual[i]) == 0);
    }

}