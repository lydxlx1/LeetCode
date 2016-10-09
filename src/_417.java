import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 417 - Pacific Atlantic Water Flow
 * <p>
 * Reachability test
 */
public class _417 {

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    private void dfs(int i, int j, int[][] a, int[][] mask, int bit) {
        mask[i][j] |= bit;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < a.length && y >= 0 && y < a[0].length && a[x][y] >= a[i][j] && (mask[x][y] & bit) == 0)
                dfs(x, y, a, mask, bit);
        }
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int[][] mask = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) {
                if ((i == 0 || j == 0) && (mask[i][j] & 1) == 0) dfs(i, j, matrix, mask, 1);
                if ((i == matrix.length - 1 || j == matrix[0].length - 1) && (mask[i][j] & 2) == 0)
                    dfs(i, j, matrix, mask, 2);
            }
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (mask[i][j] == 3) ans.add(new int[]{i, j});
        return ans;
    }
}