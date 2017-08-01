/**
 * LeetCode 651 - 4 Keys Keyboard
 * <p>
 * O(n^2)-time DP
 */
public class _651 {
    public int maxA(int N) {
        int[] f = new int[N + 1];
        f[0] = 0;
        for (int i = 0; i < N; i++) {
            f[i + 1] = Math.max(f[i + 1], f[i] + 1);
            for (int j = i + 3; j <= N; j++) {
                f[j] = Math.max(f[j], (j - i - 1) * f[i]);
            }
        }
        return f[N];
    }

    public static void main(String[] args) {
        System.out.println(new _651().maxA(7));
    }
}