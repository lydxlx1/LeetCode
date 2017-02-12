/**
 * LeetCode 493 - Reverse Pairs
 * <p>
 * Merge-sort approach
 */
public class _493 {
    public int reversePairs(int[] nums) {
        return dfs(nums, new int[nums.length], 0, nums.length - 1);

    }

    private int dfs(int[] a, int[] buf, int l, int r) {
        if (l >= r) return 0;
        int mid = (l + r) / 2, i = l, j = mid + 1, k = l;
        int ans = dfs(a, buf, l, mid) + dfs(a, buf, mid + 1, r);

        // Compute
        for (i = l; i <= mid; i++) {
            while (j <= r && a[i] > 2L * a[j]) j++;
            ans += j - (mid + 1);
        }

        // Merge
        i = l;
        j = mid + 1;
        while (i <= mid && j <= r)
            if (a[i] < a[j]) buf[k++] = a[i++];
            else buf[k++] = a[j++];
        while (i <= mid) buf[k++] = a[i++];
        while (j <= r) buf[k++] = a[j++];
        System.arraycopy(buf, l, a, l, r - l + 1);

        return ans;
    }
}


