import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class _406Test {

    @Test
    public void test() throws Exception {
        _406 sol = new _406();
        int[][] input = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        List<?> actual = to2DList(sol.reconstructQueue(input));
        List<?> expected = to2DList(new int[][]{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}});
        assertEquals(expected, actual);
    }

    private List<List<Integer>> to2DList(int[][] arr) {
        List<List<Integer>> list = new ArrayList<>(arr.length);
        for (int[] each : arr) {
            List<Integer> inner = new ArrayList<>(each.length);
            for (int num : each) inner.add(num);
            list.add(inner);
        }
        return list;
    }
}