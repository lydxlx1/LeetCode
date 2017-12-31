import java.util.*;

/**
 * LeetCode 759 - Set Intersection Size At Least Two
 * <p>
 * Sweepline + Greedy
 * O(n log n)-time
 */
public class _759 {

    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.<int[]>comparingInt(i -> i[1]).thenComparingInt(i -> i[0]));
        TreeSet<Integer> set = new TreeSet<>();

        for (int[] interval : intervals) {
            int begin = interval[0], end = interval[1];
            List<Integer> cand = new ArrayList<>();
            for (int i : set.tailSet(begin)) {
                if (i <= end) {
                    cand.add(i);
                } else {
                    break;
                }
                if (cand.size() >= 2) {
                    break;
                }
            }

            if (cand.size() == 0) {
                set.add(end - 1);
                set.add(end);
            } else if (cand.size() == 1) {
                if (!cand.contains(end)) {
                    set.add(end);
                } else {
                    set.add(end - 1);
                }
            }
        }

        return set.size();
    }
}



