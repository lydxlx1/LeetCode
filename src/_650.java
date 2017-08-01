import java.util.Arrays;

/**
 * LeetCode 650 - 2 Keys Keyboard
 * <p>
 * O(n log n)-time DP
 */
public class _650 {

    public int minSteps(int n) {
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2);
        f[1] = 0;
        for (int i = 1; i < n; i++) {
            int cnt = f[i] + 1;
            for (int j = i + i; j <= n; j += i) {
                cnt++;
                f[j] = Math.min(f[j], cnt);
            }
        }
        System.out.println(Arrays.toString(f));
        return f[n];
    }

    public static void main(String[] args) {
        new _650().minSteps(7);
    }

}