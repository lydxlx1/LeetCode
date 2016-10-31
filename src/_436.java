import java.util.TreeMap;

/**
 * LeetCode 436 - Find Right Interval
 * <p>
 * TreeMap
 */
public class _436 {
    public int[] findRightInterval(Interval[] intervals) {
        int[] ans = new int[intervals.length];
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) tree.put(intervals[i].start, i);
        for (int i = 0; i < intervals.length; i++) {
            Integer key = tree.ceilingKey(intervals[i].end);
            if (key == null) ans[i] = -1;
            else ans[i] = tree.get(key);
        }
        return ans;
    }
}