/**
 * LeetCode 1037 - Valid Boomerang
 *
 * Cross-product
 */
public class _1037 {

    public boolean isBoomerang(int[][] points) {
        long x1 = points[0][0] - points[1][0];
        long y1 = points[0][1] - points[1][1];
        long x2 = points[0][0] - points[2][0];
        long y2 = points[0][1] - points[2][1];
        return x1 * y2 - x2 * y1 != 0;
    }
}
