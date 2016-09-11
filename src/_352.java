import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * LeetCode 352 - Data Stream as Disjoint Intervals
 * <p>
 * Use a BST to save disjoint intervals ordered by (say) left endpoints.
 */
public class _352 {
    TreeMap<Integer, Interval> map;

    public _352() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) return;
        Integer low = map.lowerKey(val);
        Integer high = map.higherKey(val);
        if (low != null && high != null && map.get(low).end + 1 == val && val + 1 == high) {
            map.get(low).end = map.get(high).end;
            map.remove(high);
        } else if (low != null && map.get(low).end + 1 >= val) {
            map.get(low).end = Math.max(map.get(low).end, val);
        } else if (high != null && val + 1 == high) {
            map.put(val, new Interval(val, map.get(high).end));
            map.remove(high);
        } else {
            map.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}
