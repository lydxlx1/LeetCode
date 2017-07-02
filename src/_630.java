import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode 630 - Course Schedule III
 * <p>
 * Sweep line + greedy
 */
public class _630 {
    public int scheduleCourse(int[][] courses) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.sort(courses, Comparator.comparingInt(u -> u[1]));
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            queue.add(course[0]);
            if (time > course[1])
                time -= queue.poll();
        }
        return queue.size();
    }
}