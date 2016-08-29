import java.util.Arrays;

/**
 * LeetCode 370 Range Addition
 *
 * O(n) Prefix Trick
 */
public class _370_2 {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for (int[] update : updates) {
            ans[update[1]] += update[2];
            if (update[0] > 0) ans[update[0] - 1] -= update[2];
        }
        for (int i = ans.length - 2; i >= 0; i--) ans[i] += ans[i + 1];
        return ans;
    }
}