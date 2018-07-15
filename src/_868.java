/**
 * LeetCode 868 - Binary Gap
 * <p>
 * Brute-force
 */
public class _868 {

    public int binaryGap(int N) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (((1 << i) & N) != 0) {
                for (int j = i + 1; j < 32; j++) {
                    if (((1 << j) & N) != 0) {
                        ans = Math.max(ans, j - i);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}

