/**
 * LeetCode 546 - Remove boxes
 * <p>
 * O(n^4)-time DP
 * We can further reduce the runtime to O(n^3).
 */
public class _546 {
    int[][][] f;
    int[][] indices;
    int[] boxes;

    private int F(int left, int right, int extraLength) {
        if (left > right) return 0;
        if (f[left][right][extraLength] > 0) return f[left][right][extraLength];
        int ans = F(left, right - 1, 0) + (extraLength + 1) * (extraLength + 1);
        for (int i = left; i < right; i++)
            if (boxes[i] == boxes[right]) {
                ans = Math.max(ans, F(left, i, extraLength + 1) + F(i + 1, right - 1, 0));
            }
        f[left][right][extraLength] = ans;
        return ans;
    }

    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) return 0;
        int n = boxes.length;
        this.f = new int[n][n][n + 1];
        this.boxes = boxes;
        return F(0, boxes.length - 1, 0);
    }

    public static void main(String[] args) {
        _546 sol = new _546();
        System.out.println(sol.removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}));
    }
}
