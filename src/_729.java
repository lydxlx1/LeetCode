import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * LeetCode 729 - My Calendar I
 * <p>
 * Sweepline algorithm
 * +1 when encounter a left endpoint
 * -1 when encounter a right endpoint
 * <p>
 * When a left and right endpoint share the same location, put the right endpoint before the left one.
 */
public class _729 {

    Map<int[], Integer> map = new TreeMap<>(Comparator.<int[]>comparingInt(u -> u[0]).thenComparing(u -> u[1]));

    public _729() {

    }

    public boolean book(int start, int end) {
        int[] left = {start, 1};
        int[] right = {end, -1};
        map.put(left, map.getOrDefault(left, 0) + 1);
        map.put(right, map.getOrDefault(right, 0) + 1);
        int cnt = 0;
        for (Map.Entry<int[], Integer> it : map.entrySet()) {  // It is slower to use map.keySet()
            int[] l = it.getKey();
            cnt += l[1] * it.getValue();
            if (cnt >= 2) {
                map.put(left, map.getOrDefault(left, 0) - 1);
                map.put(right, map.getOrDefault(right, 0) - 1);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _729 cal = new _729();
        System.out.println(cal.book(10, 20));
        System.out.println(cal.book(15, 25));
        System.out.println(cal.book(20, 30));
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */