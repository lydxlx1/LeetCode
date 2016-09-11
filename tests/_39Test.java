import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Yuan on 9/10/2016.
 */
public class _39Test {
    @Test
    public void test() {
        _39 sol = new _39();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> actual = sol.combinationSum(candidates, target);
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(7), Arrays.asList(2, 2, 3));
        assertEquals(expected.size(), actual.size());
        assertEquals(toSortedSet(expected), toSortedSet(actual));
    }

    private Set<List<Integer>> toSortedSet(List<List<Integer>> list) {
        Set<List<Integer>> set = new HashSet<>();
        for (List<Integer> each : list) {
            List<Integer> sorted = new ArrayList<>(each);
            Collections.sort(sorted);
            set.add(sorted);
        }
        return set;
    }
}