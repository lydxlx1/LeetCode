import java.util.Arrays;

/**
 * LeetCode 356 - Line Reflection
 *
 * In-place solution
 */
public class _356 {
    public boolean isReflected(int[][] points) {
        Arrays.sort(points, (u, v) -> {
            if (u[1] != v[1]) return Integer.compare(u[1], v[1]);
            else return Integer.compare(u[0], v[0]);
        });
        int sum = 0, n = points.length;
        boolean hasSum = false;
        for (int i = 0; i < points.length; ) {
            int j = i;
            while (j + 1 < points.length && points[i][1] == points[j + 1][1]) j++;

            int left = i, right = j;
            while (left <= right) { // has to use <=, otherwise single element will be missed.
                while (left < right && points[left][0] == points[left + 1][0]) left++;
                while (left < right && points[right][0] == points[right - 1][0]) right--;
                if (left <= right) {
                    if (hasSum && points[left][0] + points[right][0] != sum) return false;
                    sum = points[left++][0] + points[right--][0];
                    hasSum = true;
                }
            }
            i = j + 1;
        }
        return true;
    }
}
