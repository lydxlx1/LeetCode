/**
 * LeetCode 492 - Construct the Rectangle
 * <p>
 * Brute-force
 */
public class _492 {

    public int[] constructRectangle(int area) {
        int[] ans = null;
        for (int i = 1; i * i <= area; i++) {
            if (area % i == 0) {
                ans = new int[]{area / i, i};
            }
        }
        return ans;
    }
}
