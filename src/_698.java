/**
 * LeetCode 698 - Partition to K Equal Sum Subsets
 * <p>
 * Bit-DP
 * <p>
 * High-level logic is:
 * for each mask in [0, 2^n)
 * for each j in [0, 2^(bits of mask))
 * do the dp stuff...
 * <p>
 * Seems like the complexity is very high, but it is not.
 * The true complexity is
 * sum((n choose i) * 2^i), i = 0 to n
 * <p>
 * This summation is equal to 3^n, so the overral complexity is O(3^n).
 * <p>
 * A recursive (with memoization) DP here will generally run much faster because we don't need to exhaust every state
 * in most cases.
 */
public class _698 {
    static int[] log2 = new int[1 << 16];

    static {
        for (int i = 0; i < 16; i++)
            log2[1 << i] = i;
    }

    int[] sum;
    int n;
    int[] a;
    int total = 0;
    int partial = 0;
    Boolean[] f;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return false;
        if (k == 1) return true;

        n = nums.length;
        a = nums;
        sum = new int[1 << n];
        for (int i = 1; i < sum.length; i++) {
            int lowbit = log2[Integer.lowestOneBit(i)];
            sum[i] = a[lowbit] + sum[i - (1 << lowbit)];
        }
        total = sum[(1 << n) - 1];
        if (total % k != 0)
            return false;

        partial = total / k;
        for (int num : a)
            if (num > partial)
                return false;

        f = new Boolean[1 << n];
        return dfs((1 << n) - 1);
    }

    boolean dfs(int mask) {
        if (sum[mask] == partial) return true;
        if (f[mask] != null) return f[mask];

        int[] bits = new int[Integer.bitCount(mask)];
        int len = 0, tmp = mask;
        while (tmp > 0) {
            int lowbit = log2[Integer.lowestOneBit(tmp)];
            bits[len++] = lowbit;
            tmp -= 1 << lowbit;
        }

        boolean ans = false;
        if (len == 1) {
            ans = sum[mask] == partial;
        } else {
            for (int i = 0; i < (1 << (len - 1)); i++) {
                int subMask = 1 << bits[len - 1];

                tmp = i;
                while (tmp > 0) {
                    int lowbit = log2[Integer.lowestOneBit(tmp)];
                    subMask |= 1 << bits[lowbit];
                    tmp -= 1 << lowbit;
                }

                if (sum[subMask] == partial && dfs(mask - subMask)) {
                    ans = true;
                    break;
                }
            }
        }

        f[mask] = ans;
        return ans;
    }


    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        System.out.println(sol.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println(sol.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 3));
        System.out.println(sol.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 5));
        System.out.println(sol.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 2));
        System.out.println(sol.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 1));
        System.out.println(sol.canPartitionKSubsets(new int[]{1, 1, 1, 1, 1}, 5));
        System.out.println(sol.canPartitionKSubsets(new int[]{1, 1, 1, 1, 1}, 4));
        System.out.println(sol.canPartitionKSubsets(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(sol.canPartitionKSubsets(new int[]{1, 1, 1, 1, 1, 1}, 3));
        System.out.println(sol.canPartitionKSubsets(new int[]{1, 1, 1, 1, 1}, 2));
    }
}