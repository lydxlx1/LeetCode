import java.util.*;

/**
 * LeetCode My Calendar II
 * <p>
 * Same as LC 729
 */
public class _731 {

    Map<int[], Integer> map = new TreeMap<>();

    public _731() {

    }

    public boolean book(int start, int end) {
        int[] left = {start, 1};
        int[] right = {end, -1};
        map.put(left, map.getOrDefault(left, 0) + 1);
        map.put(right, map.getOrDefault(right, 0) + 1);
        int cnt = 0;
        for (Map.Entry<int[], Integer> it : map.entrySet()) {
            int[] l = it.getKey();
            cnt += l[1] * it.getValue();
            if (cnt >= 3) {
                map.put(left, map.getOrDefault(left, 0) - 1);
                map.put(right, map.getOrDefault(right, 0) - 1);
                return false;
            }
        }
        return true;
    }
}