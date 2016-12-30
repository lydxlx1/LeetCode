/**
 * LeetCode 361 - Bomb Enemy
 * <p>
 * Four DPs
 */
public class _361 {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length <= 0 || grid[0].length <= 0) return 0;
        int r = grid.length, c = grid[0].length;
        int[][] up = new int[r][c];
        int[][] down = new int[r][c];
        int[][] left = new int[r][c];
        int[][] right = new int[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (grid[i][j] != 'W')
                    up[i][j] = (i == 0 ? 0 : up[i - 1][j]) + (grid[i][j] == 'E' ? 1 : 0);
        for (int i = r - 1; i >= 0; i--)
            for (int j = 0; j < c; j++)
                if (grid[i][j] != 'W')
                    down[i][j] = (i == r - 1 ? 0 : down[i + 1][j]) + (grid[i][j] == 'E' ? 1 : 0);
        for (int j = 0; j < c; j++)
            for (int i = 0; i < r; i++)
                if (grid[i][j] != 'W')
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + (grid[i][j] == 'E' ? 1 : 0);
        for (int j = c - 1; j >= 0; j--)
            for (int i = 0; i < r; i++)
                if (grid[i][j] != 'W')
                    right[i][j] = (j == c - 1 ? 0 : right[i][j + 1]) + (grid[i][j] == 'E' ? 1 : 0);

        int ans = 0;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (grid[i][j] == '0')
                    ans = Math.max(ans, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
        return ans;
    }

    public static void main(String[] args) {
        char[][] a = {
                "0E00".toCharArray(),
                "E0WE".toCharArray(),
                "0E00".toCharArray()
        };
        System.out.println(new _361().maxKilledEnemies(a));
    }
}