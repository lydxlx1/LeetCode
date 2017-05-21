import java.util.Arrays;

/**
 * LeetCode 593 - Valid Square
 * <p>
 * An elegant solution
 * <p>
 * 1) No two points should be at the same location.
 * 2) There exist four shorter edges with equal length, which guarantees it is a diamond.
 * 3) The remaining two longer edges (diagonals) should have equal length, meaning the diamond is also a rectangle.
 */
public class _593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] a = {p1, p2, p3, p4};
        int[] d = new int[6];
        for (int i = 0, ptr = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                d[ptr++] = dist2(a[i], a[j]);
        Arrays.sort(d);
        return d[0] > 0 && d[0] == d[3] && d[3] < d[4] && d[4] == d[5];
    }

    private int dist2(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x * x + y * y;
    }
}