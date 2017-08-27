import java.util.stream.IntStream;

/**
 * LeetCode 667 - Beautiful Arrangement II
 * <p>
 * Constructive Approach
 * <p>
 * One possible attempt is to construct an array [a_1, a_2, ..., a_n] such that
 * the absolute consecutive difference array is
 * [1, 2, 3, ..., k, 1, 1, ..., 1].
 * <p>
 * To achieve that, we judiciously reorder the first k elements.
 * For example, n = 8, k = 5.
 * <p>
 * Step 0: a = [?, ?, ?, ?, ?, 6, 7, 8], diff = [?, ?, ?, ?, ?, 1, 1].
 * Step 1: a = [?, ?, ?, ?, 1, 6, 7, 8], diff = [?, ?, ?, ?, 5, 1, 1].
 * Step 2: a = [?, ?, ?, 5, 1, 6, 7, 8], diff = [?, ?, ?, 4, 5, 1, 1].
 * Step 3: a = [?, ?, 2, 5, 1, 6, 7, 8], diff = [?, ?, 3, 4, 5, 1, 1].
 * Step 4: a = [?, 4, 2, 5, 1, 6, 7, 8], diff = [?, 2, 3, 4, 5, 1, 1].
 * Step 5: a = [3, 4, 2, 5, 1, 6, 7, 8], diff = [1, 2, 3, 4, 5, 1, 1].
 * Done.
 */
class _667 {
    public int[] constructArray(int n, int k) {
        int[] a = IntStream.rangeClosed(1, n).toArray();
        int[] b = IntStream.rangeClosed(1, k).toArray();
        for (int i = 0, j = k - 1, pos = k - 1; i <= j; ) {
            a[pos--] = b[i++];
            if (i <= j) {
                a[pos--] = b[j--];
            }
        }
        return a;
    }
}