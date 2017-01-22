/**
 * LeetCode 492 - Construct the Rectangle
 * <p>
 * Brute-force
 */
public class _492 {

    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        for (int i = 1; i * i <= area; i++) {
            if (area % i == 0) {
                int cb = Math.max(i, area / i);
                int wb = Math.min(i, area / i);

                if (ans[0] == 0 || ans[0] - ans[1] > cb - wb) {
                    ans[0] = cb;
                    ans[1] = wb;
                }
            }
        }
        return ans;
    }
}
