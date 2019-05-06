import java.util.Arrays;

/**
 * LeetCode 1040 - Moving Stones Until Consecutive II
 *
 * Math
 */
public class _1040 {

    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;

        int maxMoves = 0;
        for (int i = 0; i < n - 1; i++) {
            maxMoves += stones[i + 1] - stones[i] - 1;
        }
        // First empty gap (either the leftmost one or rightmost one) must be wasted.
        // Prefer the shorter one.
        maxMoves -= Math.min(stones[1] - stones[0] - 1, stones[n - 1] - stones[n - 2] - 1);

        int minMoves = 1 << 29;
        for (int i = 0, j = 0; i < stones.length; i++) {
            while (j + 1 < stones.length && stones[j + 1] - stones[i] + 1 <= n) {
                j++;
            }
            int windowSize = stones[j] - stones[i] + 1;
            int stoneCnt = j - i + 1;
            if (windowSize == n - 1 && windowSize == stoneCnt) {
                // This is the only case (i.e., a single stone apart of a continuous chunk)
                // where we need an extra move.
                minMoves = Math.min(minMoves, 2);
            } else {
                minMoves = Math.min(minMoves, n - stoneCnt);
            }
        }
        return new int[]{minMoves, maxMoves};
    }
}
