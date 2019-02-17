import java.util.stream.IntStream;

/**
 * LeetCode 995 - Minimum Number of K Consecutive Bit Flips
 *
 * Starting from the leftmost (or the rightmost) bit, then the choice of flipping this bit is indeed unique.
 * We then need a data structure that supports efficient (i) interval addition and (ii) point query.
 * Binary Index Tree works. Further, if we notice that all the intervals have the same length (i.e., K),
 * a (simpler) sliding window method suffices to solve the problem (and has better performance).
 */
public class _995 {

    public int minKBitFlips(int[] A, int K) {
        int[] cnt = new int[A.length];

        int window = 0;
        for (int i = 0; i < A.length; i++) {
            window -= i - K >= 0 ? cnt[i - K] : 0;

            if ((window + A[i]) % 2 == 0) {
                if (i + K <= A.length) {
                    cnt[i]++;
                    window++;
                } else {
                    return -1;
                }
            }
        }
        return IntStream.of(cnt).sum();
    }
}

