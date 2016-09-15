import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class _305Test {

    @Test
    public void test() throws Exception {
        _305 sol = new _305();
        List<Integer> actual = sol.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}});
        List<Integer> expected = Arrays.asList(1, 1, 2, 3);
        assertEquals(expected, actual);

        actual = sol.numIslands2(3, 3, new int[][]{});
        expected = Arrays.asList();
        assertEquals(expected, actual);

        actual = sol.numIslands2(3, 3, new int[][]{{1, 1}});
        expected = Arrays.asList(1);
        assertEquals(expected, actual);
    }
}