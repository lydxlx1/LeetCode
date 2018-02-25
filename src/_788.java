import java.util.stream.IntStream;

/**
 * LeetCode 788 - Rotated Digits
 */
public class _788 {

    public int rotatedDigits(int N) {
        return (int) IntStream.rangeClosed(1, N).filter(i -> is(i)).count();
    }

    boolean is(int x) {
        final int[] map = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};
        int rotated = 0, backup = x, base = 1;
        while (x > 0) {
            int d = x % 10;
            if (map[d] == -1) {
                return false;
            } else {
                rotated += map[d] * base;
                base *= 10;
                x /= 10;
            }
        }
        return backup != rotated;
    }
}
