import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Number of Equivalent Domino Pairs
 *
 * Counting
 */
public class NumberOfEquivalentDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<List<Integer>, Integer> set = new HashMap<>();
        int ans = 0;
        for (int[] pair : dominoes) {
            List<Integer> key = Arrays.asList(Math.min(pair[0], pair[1]), Math.max(pair[0], pair[1]));
            ans += set.getOrDefault(key, 0);
            set.put(key, set.getOrDefault(key, 0) + 1);
        }
        return ans;
    }
}


