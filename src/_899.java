import java.util.Arrays;

/**
 * LeetCode 899 - Orderly Queue
 * <p>
 * Just need to notice that when K = 2 (hence any K >= 2), we can swap any adjacent characters, therefore, we can indeed
 * sort the original string.
 */
public class _899 {

    public String orderlyQueue(String S, int K) {
        char[] chars = S.toCharArray();
        if (K > 1) {
            Arrays.sort(chars);
            return String.valueOf(chars);
        } else {
            // The runtime can be further improved by the suffix array idea.
            String ans = S;
            String SS = S + S;
            for (int i = 0; i < S.length(); i++) {
                String tmp = SS.substring(i, i + S.length());
                if (tmp.compareTo(ans) < 0) {
                    ans = tmp;
                }
            }
            return ans;
        }
    }
}

