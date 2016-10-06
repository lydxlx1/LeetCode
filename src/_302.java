/**
 * LeetCode 302 - Smallest Rectangle Enclosing Black Pixels
 * <p>
 * Not sure why this is problem is hard...
 */
public class _302 {
    int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
    int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;

    private void dfs(char[][] g, int x, int y) {
        if (x < 0 || x >= g.length || y < 0 || y >= g[0].length || g[x][y] == '0') return;
        g[x][y] = '0';
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
        dfs(g, x + 1, y);
        dfs(g, x - 1, y);
        dfs(g, x, y + 1);
        dfs(g, x, y - 1);
    }

    public int minArea(char[][] image, int x, int y) {
        minX = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;
        minY = Integer.MAX_VALUE;
        maxY = Integer.MIN_VALUE;
        dfs(image, x, y);
        return (maxX - minX + 1) * (maxY - minY + 1);
    }
}