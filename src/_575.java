import java.util.stream.IntStream;

/**
 * LeetCode 575 - Distribute Candies
 * <p>
 * Greedy
 */
public class _575 {
    public int distributeCandies(int[] candies) {
        return Math.min((int) IntStream.of(candies).distinct().count(), candies.length / 2);
    }
}
