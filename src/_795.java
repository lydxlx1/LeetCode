/**
 * LeetCode 795 - Number of Subarrays with Bounded Maximum
 * <p>
 * Divided-and-conquer approach
 */
public class _795 {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {

        return dfs(A, 0, A.length - 1, R) - dfs(A, 0, A.length - 1, L - 1);
    }

    private int dfs(int[] a, int l, int r, int max) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return a[l] <= max ? 1 : 0;
        }

        int cnt = 0;
        int mid = (l + r) / 2;

        cnt += dfs(a, l, mid, max);
        cnt += dfs(a, mid + 1, r, max);

        int lCnt = 0, rCnt = 0;
        for (int i = mid; i >= l; i--) {
            if (a[i] <= max) {
                lCnt++;
            } else {
                break;
            }
        }
        for (int i = mid + 1; i <= r; i++) {
            if (a[i] <= max) {
                rCnt++;
            } else {
                break;
            }
        }

        cnt += lCnt * rCnt;
        return cnt;
    }
}
