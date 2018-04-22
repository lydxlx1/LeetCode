import java.util.Arrays;
import java.util.TreeSet;


/**
 * LeetCode 821 - Shortest Distance to a Character
 * <p>
 * Brute-force
 */
public class _821 {

    public int[] shortestToChar(String S, char C) {
        TreeSet<Integer> tree = new TreeSet<>();
        int[] res = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                tree.add(i);
            }
        }
        for (int i = 0; i < S.length(); i++) {
            res[i] = Integer.MAX_VALUE;
            Integer pos = null;

            pos = tree.floor(i);
            if (pos != null) {
                res[i] = Math.min(res[i], Math.abs(pos - i));
            }

            pos = tree.ceiling(i);
            if (pos != null) {
                res[i] = Math.min(res[i], Math.abs(pos - i));
            }
        }

        return res;
    }
}

