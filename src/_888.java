import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * LeetCode 888 - Fair Candy Swap
 * <p>
 * Solution
 */
public class _888 {

    public int[] fairCandySwap(int[] A, int[] B) {
        Set<Long> setB = new HashSet<>();
        for (int b : B) {
            setB.add(2L * b);
        }

        long sumA = IntStream.of(A).mapToLong(i -> i).sum();
        long sumB = IntStream.of(B).mapToLong(i -> i).sum();

        for (int a : A) {
            long _2b = sumB - sumA + 2 * a;
            if (setB.contains(_2b)) {
                int b = (int) _2b / 2;
                return new int[]{a, b};
            }
        }

        throw new RuntimeException("");
    }
}

