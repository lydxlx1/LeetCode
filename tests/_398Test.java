import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class _398Test {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void test() {
        int[] a = {1, 2, 3, 3, 3, 1};
        _398 sol = new _398(a);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            int index = sol.pick(1);
            map.putIfAbsent(index, 0);
            map.put(index, map.get(index) + 1);
        }
        assertEquals(new HashSet<>(Arrays.asList(0, 5)), map.keySet());
        assertTrue(check(map.values()));

        map.clear();
        for (int i = 0; i < 100000; i++) {
            int index = sol.pick(2);
            map.putIfAbsent(index, 0);
            map.put(index, map.get(index) + 1);
        }
        assertEquals(new HashSet<>(Arrays.asList(1)), map.keySet());
        assertTrue(check(map.values()));

        map.clear();
        for (int i = 0; i < 100000; i++) {
            int index = sol.pick(3);
            map.putIfAbsent(index, 0);
            map.put(index, map.get(index) + 1);
        }
        assertEquals(new HashSet<>(Arrays.asList(2, 3, 4)), map.keySet());
        assertTrue(check(map.values()));
    }

    private boolean check(Collection<Integer> cnt) {
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : cnt) {
            sum += i;
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return (double) (max - min) / sum < 0.01;
    }
}