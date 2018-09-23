import java.util.stream.IntStream;

/**
 * LeetCode 908 - Smallest Range I
 *
 * Greedy
 */
public class _908 {

    public int smallestRangeI(int[] A, int K) {
        int max = IntStream.of(A).max().getAsInt();
        int min = IntStream.of(A).min().getAsInt();
        return Math.max(0, max - min - 2 * K);
    }
}

