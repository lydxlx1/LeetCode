import java.util.Arrays;


/**
 * LeetCode 821 - Shortest Distance to a Character
 * <p>
 * Brute-force
 */
public class _821_1 {

    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        Arrays.fill(res, Integer.MAX_VALUE);


        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                res[i] = 0;
            }
        }

        // Scan from left to right
        for (int pre = -1, i = 0; i < S.length(); i++) {
            if (res[i] == 0) {
                for (int j = pre + 1; j < i; j++) {
                    res[j] = Math.min(res[j], i - j);
                }
                pre = i;
            }
        }

        // Scan from right to left
        for (int pre = S.length(), i = S.length() - 1; i >= 0; i--) {
            if (res[i] == 0) {
                for (int j = i + 1; j < pre; j++) {
                    res[j] = Math.min(res[j], j - i);
                }
                pre = i;
            }
        }
        return res;
    }
}

