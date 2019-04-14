import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 1016 -  Binary String With Substrings Representing 1 To N
 *
 * Brute-force
 * Just need to enumerate every substring of S and compute the binary number using a rolling-sum fashion.
 */
public class _1016 {

    public boolean queryString(String S, int N) {
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < S.length(); i++) {
            long val = S.charAt(i) - '0';
            visited.add((int) val);
            for (int j = i + 1; j < S.length(); j++) {
                val = (val << 1) + S.charAt(j) - '0';
                if (val > N) {
                    break;
                }
                visited.add((int) val);
            }
        }

        if (visited.size() < N) {
            return false;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited.contains(i)) {
                return false;
            }
        }
        return true;
    }
}

