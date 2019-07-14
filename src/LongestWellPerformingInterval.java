import java.util.Arrays;


/**
 * Longest Well-Performing Interval
 *
 * Note that it is incorrect to bisect the solution as the example [9, 6, 9].
 *
 * This solution leverages BIT (binary indexed tree) to speed up the operation to add an element to some place of array
 * while maintaining the current minimum value of all prefixes.
 */
public class LongestWellPerformingInterval {

    int[] bit;
    int inf = 1 << 29;
    final int offset = 10001;

    void insert(int i, int val) {
        i += offset;
        for (; i < bit.length; i += Integer.lowestOneBit(i)) {
            bit[i] = Math.min(bit[i], val);
        }
    }

    int query(int i) {
        i += offset;
        int ans = inf;
        for (; i > 0; i -= Integer.lowestOneBit(i)) {
            ans = Math.min(ans, bit[i]);
        }
        return ans;
    }

    public int longestWPI(int[] hours) {
        int ans = 0;
        bit = new int[3 * offset];
        Arrays.fill(bit, inf);
        int sum = 0;
        insert(0, -1);
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            ans = Math.max(ans, i - query(sum - 1));
            insert(sum, i);
        }
        return ans;
    }
}


