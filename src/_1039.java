/**
 * LeetCode 1039 - Minimum Score Triangulation of Polygon
 *
 * DP
 * Let f[i][j] denote the minimum score triangulation of the polygon of vertices A[i], A[i+1], ... A[j].
 * Note that this also includes the edge from A[i] to A[j].
 *
 * For a recursive form, we just need to enumerate the vertex k (i < k < j) that forms a triangle with edge (A[i], A[j]).
 * Then, we naturally have two sub-problems, f[i][k] and f[k][j].
 */
public class _1039 {

    public int minScoreTriangulation(int[] A) {
        return f(0, A.length - 1, A, new Integer[A.length][A.length]);
    }

    int f(int i, int j, int[] a, Integer[][] memo) {
        if (i + 1 >= j) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int ans = 1 << 29;
        for (int k = i + 1; k < j; k++) {
            ans = Math.min(ans, f(i, k, a, memo) + f(k, j, a, memo) + a[i] * a[j] * a[k]);

        }
        memo[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        _1039 sol = new _1039();

        System.out.println(sol.minScoreTriangulation(new int[]{3, 7, 4, 5}));
        System.out.println(sol.minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5}));
    }
}
