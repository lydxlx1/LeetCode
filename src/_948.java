import java.util.Arrays;

/**
 * LeetCode 948 - Bag of Tokens
 *
 * Greedy
 */
public class _948 {

    public int bagOfTokensScore(int[] tokens, int P) {
        int ans = 0, points = 0;
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1;
        while (i <= j) {
            if (tokens[i] <= P) {
                P -= tokens[i++];
                points++;
                ans = Math.max(ans, points);
            } else if (points > 0) {
                points--;
                P += tokens[j--];
            } else {
                break;
            }
        }
        return ans;
    }
}

