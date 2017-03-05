import java.util.Arrays;

/**
 * LeetCode 514 - Freedom Trail
 * <p>
 * An O(RK)-time solution
 */
public class _514_1 {

    public int findRotateSteps(String ring, String key) {
        int R = ring.length(), K = key.length();
        int[][] prev = new int[R][26], next = new int[R][26];
        for (int i = 0; i < R; i++) {
            Arrays.fill(prev[i], -1);
            Arrays.fill(next[i], -1);
            for (int j = (i + 1) % R; j != i; j = (j + 1) % R) {
                int ch = ring.charAt(j) - 'a';
                if (next[i][ch] == -1) next[i][ch] = j;
            }
            for (int j = (i - 1 + R) % R; j != i; j = (j - 1 + R) % R) {
                int ch = ring.charAt(j) - 'a';
                if (prev[i][ch] == -1) prev[i][ch] = j;
            }
            prev[i][ring.charAt(i) - 'a'] = next[i][ring.charAt(i) - 'a'] = i;
        }

        int[][] f = new int[K][R];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < R; j++) {
                f[i][j] = Integer.MAX_VALUE / 2;

                if (key.charAt(i) == ring.charAt(j)) {
                    if (i == 0) f[i][j] = Math.min(f[i][j], dist(0, j, ring.length()));
                    else {
                        int preKey = key.charAt(i - 1) - 'a';
                        f[i][j] = Math.min(f[i][j], f[i - 1][prev[j][preKey]] + dist(prev[j][preKey], j, ring.length()));
                        f[i][j] = Math.min(f[i][j], f[i - 1][next[j][preKey]] + dist(next[j][preKey], j, ring.length()));
                    }
                }
                if (i == key.length() - 1) ans = Math.min(ans, f[i][j]);
            }
        }
        return ans + key.length();
    }

    private int dist(int i, int j, int n) {
        return Math.min(Math.abs(i - j), n - Math.abs(i - j));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new _514_1().findRotateSteps("abc", "aaccbb"));
    }
}
