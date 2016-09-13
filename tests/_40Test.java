import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class _40Test {

    private boolean match(List<List<Integer>> a, List<List<Integer>> b) {
        for (List<Integer> list : a) Collections.sort(list);
        for (List<Integer> list : b) Collections.sort(list);
        Collections.sort(a, (u, v) -> u.toString().compareTo(v.toString()));
        Collections.sort(b, (u, v) -> u.toString().compareTo(v.toString()));
        return a.equals(b);
    }

    @Test
    public void test() throws Exception {
        _40 sol = new _40();
        List<List<Integer>> actual = sol.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 7), Arrays.asList(1, 2, 5), Arrays.asList(2, 6), Arrays.asList(1, 1, 6));
        assertTrue(String.format("%nactual = %s%nexpected = %s%n", actual, expected), match(expected, actual));

        actual = sol.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 0);
        expected = Arrays.asList(Arrays.asList());
        assertTrue(String.format("%nactual = %s%nexpected = %s%n", actual, expected), match(expected, actual));
    }
}

