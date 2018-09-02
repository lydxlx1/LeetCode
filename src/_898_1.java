import java.util.Arrays;


/**
 * LeetCode 898 - Bitwise ORs of Subarrays
 * <p>
 * A more direct approach
 * However, this method heavily relies on the built-in containers and is therefore slower than the Divide-and-Conquer approach.
 */
public class _898_1 {

    public String orderlyQueue(String S, int K) {
        char[] chars = S.toCharArray();
        if (K > 1) {
            Arrays.sort(chars);
            return String.valueOf(chars);
        } else {
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

