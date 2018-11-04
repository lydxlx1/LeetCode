import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 936 - Stamping the Sequence
 *
 * Thinking reversely!
 */
public class _936 {


    List<Integer> moves;

    public int[] movesToStamp(String stamp, String target) {
        moves = new ArrayList<>();
        if (!dfs(0, target.length() - 1, stamp.toCharArray(), target.toCharArray())) {
            return new int[0];
        } else {
            return moves.stream().mapToInt(i -> i).toArray();
        }
    }

    private boolean dfs(int i, int j, char[] stamp, char[] target) {
        while (i <= j && target[i] == '*') {
            i++;
        }
        while (i <= j && target[j] == '*') {
            j--;
        }
        if (i > j) {
            return true;
        }

        for (int index = Math.max(0, i - (stamp.length - 1)); index <= j && index + stamp.length <= target.length; index++) {
            int k;
            for (k = 0; k < stamp.length; k++) {
                if (i <= index + k && index + k <= j && target[index + k] != '*' && target[index + k] != stamp[k]) {
                    break;
                }
            }
            if (k == stamp.length) {
                for (k = 0; k < stamp.length; k++) {
                    target[index + k] = '*';
                }
                if (!dfs(i, index - 1, stamp, target)) {
                    return false;
                }
                if (!dfs(index + stamp.length, j, stamp, target)) {
                    return false;
                }
                moves.add(index);
                return true;
            }
        }
        return false;
    }
}

