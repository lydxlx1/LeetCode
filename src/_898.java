import java.util.HashSet;
import java.util.Set;


/**
 * LeetCode 898 - Bitwise ORs of Subarrays
 * <p>
 * Divide-and-Conquer approach of runtime O(n (log n + 32^2)).
 */
public class _898 {

    Set<Integer> ans;

    public int subarrayBitwiseORs(int[] A) {
        ans = new HashSet<>();
        dfs(A, 0, A.length - 1, new int[A.length]);
        return ans.size();
    }

    void dfs(int[] A, int l, int r, int[] or) {
        if (l == r) {
            ans.add(A[l]);
        } else {
            int mid = (l + r) / 2, full = 0;
            dfs(A, l, mid, or);
            dfs(A, mid + 1, r, or);

            int mask = 0;
            int L = mid, R = mid + 1;
            for (int i = mid; i >= l; i--) {
                mask |= A[i];
                full |= A[i];
                if (L == mid || mask != or[L + 1]) {
                    or[L] = mask;
                    L--;
                }
            }
            mask = 0;
            for (int i = mid + 1; i <= r; i++) {
                mask |= A[i];
                full |= A[i];
                if (R == mid + 1 || mask != or[R - 1]) {
                    or[R] = mask;
                    R++;
                }
            }
            // Now, or[L+1, mid] stores all distinct or-values of subarrays in the form of A[i, mid], where l <= i <= mid.
            // Similary, or[mid+1, R-1] stores all distinct or-values of subarrays in the form of A[mid+1, i], where mid+1 <= i <= r.
            // Note that, there will be at most 32 distinct elements on each side.

            for (int i = mid; i > L; i--) {
                for (int j = mid + 1; j < R; j++) {
                    mask = or[i] | or[j];
                    ans.add(mask);
                    // Another optimization
                    if (mask == full) {
                        break;
                    }
                }
            }
        }
    }
}

