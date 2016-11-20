import java.util.Random;

/**
 * LeetCode 462 - Minimum Moves to Equal Array Elements II
 * <p>
 * Median finding via quick selection algorithm
 * <p>
 * If there are odd number of numbers, then the answer is the median.
 * If there are even number of numbers, then any point on the segment from lower median to the upper median can be the answer.
 */
public class _462 {
    final private Random rand = new Random();

    /**
     * Randomized selection
     * O(n) runtime in expectation
     */
    private int kthElement(int[] a, int k) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int i = l, j = r, x = a[rand.nextInt(r - l + 1) + l];
            do {
                while (a[i] < x) i++;
                while (a[j] > x) j--;
                if (i <= j) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    i++;
                    j--;
                }
            } while (i <= j);


            // [l, j] < [j+1, i-1] < [i, r]
            //            equals
            //             x
            if (j - l + 1 >= k) r = j;
            else if (i - 1 - l + 1 >= k) return x;
            else {
                k -= i - 1 - l + 1;
                l = i;
            }
        }
        return a[l];
    }

    public int minMoves2(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        int ans = 0;
        int median = kthElement(nums, (nums.length + 1) / 2);
        for (int i : nums) ans += Math.abs(i - median);
        return ans;
    }
}