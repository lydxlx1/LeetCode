import java.util.Comparator;
import java.util.stream.Stream;

/**
 * LeetCode 973 - K Closest Points to Origin
 *
 * 1-Liner
 */
public class _973 {

    public int[][] kClosest(int[][] points, int K) {
        return Stream.of(points).sorted(Comparator.comparingInt(arr -> arr[0] * arr[0] + arr[1] * arr[1])).limit(K).toArray(int[][]::new);
    }
}
