import java.util.*;

/**
 * LeetCode 855 - Exam Room
 * <p>
 * O(log m) amortized runtime for both seat() and leave().
 */
public class _855 {

    int N;
    TreeSet<Integer> seated = new TreeSet<>();
    PriorityQueue<List<Integer>> intervals = new PriorityQueue<>(Comparator.<List<Integer>>comparingInt(i -> -maxDistPerInterval(i)).thenComparingInt(i -> i.get(0)));

    /**
     * [x] has distance 1, seating at x
     * [x, x + 1] has distance 1, seating at x
     * [x, x + 1, x + 2] has distance 2, seating at x + 1
     * [x, x + 1, x + 2, x + 3] has distance 2, seating at x + 1
     * [x, x + 1, x + 2, x + 3, x + 4] has distance 3, seating at x + 2
     * [x, x + 1, x + 2, x + 3, x + 4, x + 5] has distance 3, seating at x + 2
     * ...
     */
    private int maxDistPerInterval(List<Integer> i) {
        return (i.get(1) - i.get(0)) / 2 + 1;
    }

    /**
     * An interval [left, right] is valid if and only if
     * <p>
     * 1. 0 <= left <= right < N
     * 2. For all i in [left, right], there is NO person currently sitting at the i-th seat.
     */
    private boolean isValid(List<Integer> interval) {
        if (interval.get(0) < 0 || interval.get(1) >= N || interval.get(0) > interval.get(1)) {
            return false;
        }
        return seated.ceiling(interval.get(0)) > interval.get(1);
    }

    public _855(int N) {
        this.N = N;
        seated.add(-1);
        seated.add(N);
    }

    public int seat() {
        while (!intervals.isEmpty() && !isValid(intervals.peek())) {
            intervals.poll();
        }

        int seat = -1, maxDistance = -1;
        if (!intervals.isEmpty()) {
            List<Integer> interval = intervals.poll();
            int dist = maxDistPerInterval(interval);
            if (dist > maxDistance) {
                maxDistance = dist;
                seat = (interval.get(0) + interval.get(1)) / 2;
            }
        }

        // Seating at 0 or N - 1 is different from other cases. So deal with them separately.
        if (!seated.contains(0) && seated.higher(0) - 0 > maxDistance) {
            maxDistance = seated.higher(0) - 0;
            seat = 0;
        }
        if (!seated.contains(N - 1) && N - 1 - seated.lower(N - 1) > maxDistance) {
            maxDistance = N - 1 - seated.lower(N - 1);
            seat = N - 1;
        }

        seated.add(seat);
        intervals.add(Arrays.asList(seated.lower(seat) + 1, seat - 1));
        intervals.add(Arrays.asList(seat + 1, seated.higher(seat) - 1));
        return seat;
    }

    public void leave(int p) {
        seated.remove(p);
        intervals.add(Arrays.asList(seated.lower(p) + 1, seated.higher(p) - 1));
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */