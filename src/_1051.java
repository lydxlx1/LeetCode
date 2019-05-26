import java.util.stream.IntStream;


/**
 * LeetCode 1051 - Height Checker
 *
 * Sorting
 *
 * Problem description is pretty bad.
 */
public class _1051 {

    public int heightChecker(int[] heights) {
        int[] sorted = IntStream.of(heights).sorted().toArray();
        int cnt = 0;
        for (int i = 0; i < heights.length; i++) {
            if (sorted[i] != heights[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
