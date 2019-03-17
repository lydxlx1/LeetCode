/**
 * LeetCode 1012 - Complement of Base 10 Integer
 *
 * Bit Manipulation
 */
public class _1012 {

    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        return (int)(((Long.highestOneBit(N) << 1) - 1) ^ N);
    }
}

