import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 850 - Rectangle Area II
 * <p>
 * Index Compressing
 */
public class _850_1 {

    public int rectangleArea(int[][] rectangles) {
        long mod = 1000000007;

        List<Integer> values = new ArrayList<>();
        for (int[] rec : rectangles) {
            for (int val : rec) {
                values.add(val);
            }
        }
        Collections.sort(values);

        int m = values.size();
        boolean[][] covered = new boolean[m][m];
        for (int[] rec : rectangles) {
            int x1 = Collections.binarySearch(values, rec[0]), x2 = Collections.binarySearch(values, rec[2]);
            int y1 = Collections.binarySearch(values, rec[1]), y2 = Collections.binarySearch(values, rec[3]);
            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    covered[i][j] = true;
                }
            }
        }

        long totalArea = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (covered[i][j]) {
                    totalArea += (long) (values.get(i + 1) - values.get(i)) * (values.get(j + 1) - values.get(j)) % mod;
                }
            }
        }
        return (int) (totalArea % mod);
    }


    public static void main(String[] args) {
        _850_1 sol = new _850_1();


        System.out.println(sol.rectangleArea(new int[][]{
                {0, 0, 2, 2},
                {1, 0, 2, 3},
                {1, 0, 3, 1},
        }));
        System.out.println(sol.rectangleArea(new int[][]{
                {0, 0, 1000000000, 1000000000},
        }));
    }
}

