import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 980 - Unique Paths III
 *
 * DP with bit-compression
 */
public class _980 {

    int[][] g;
    int r, c;
    Map<Integer, Integer> f;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    int index(int i, int j) {
        return i * c + j;
    }

    public int uniquePathsIII(int[][] grid) {
        int start = 0;
        g = grid;
        r = g.length;
        c = g[0].length;
        int hash = 0;
        int x = 0, y = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (g[i][j] == 1) {
                    x = i;
                    y = j;
                    hash |= 1 << index(i, j);
                } else if (g[i][j] == -1) {
                    hash |= 1 << index(i, j);
                }
            }
        }
        f = new HashMap<>();
        return f(hash, x, y);
    }

    int f(int hash, int i, int j) {
        int key = hash * (r * c) + index(i, j);
        if (f.containsKey(key)) {
            return f.get(key);
        }
        if (hash == ((1 << index(i, j)) - 1)) {
            return 1;
        }
        // It is invalid to visit the ending square before we have visited all non-obstacles.
        if (g[i][j] == 2) {
            return 0;
        }

        int ans = 0;
        for (int k = 0; k < 4; k++) {
            int ii = i + dx[k];
            int jj = j + dy[k];
            if (ii >= 0 && ii < r && jj >= 0 && jj < c && (hash & (1 << index(ii, jj))) == 0) {
                ans += f(hash | (1 << index(ii, jj)), ii, jj);
            }
        }
        f.put(key, ans);
        return ans;
    }
}

