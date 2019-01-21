import java.util.stream.IntStream;

/**
 * LeetCode 977 - Squares of a Sorted Array
 *
 * 1-Liner
 */
public class _977 {

    public int[] sortedSquares(int[] A) {
        return IntStream.of(A).map(i -> i * i).sorted().toArray();
    }
}

