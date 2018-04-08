/**
 * LeetCode 812 - Largest Triangle Area
 */
public class _812 {

    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double x1 = points[j][0] - points[i][0], y1 = points[j][1] - points[i][1];
                    double x2 = points[k][0] - points[i][0], y2 = points[k][1] - points[i][1];
                    double area = Math.abs(x1 * y2 - x2 * y1) / 2;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
