import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode 1048 - Longest String Chain
 *
 * DP
 * Longest simple path in DAG
 */
public class _1048 {


    public int longestStrChain(String[] words) {
        Set<String> dict = new HashSet<>();
        for (String word : words) {
            dict.add(word);
        }
        int ans = 0;
        Map<String, Integer> memo = new HashMap<>();
        for (String s : dict) {
            ans = Math.max(ans, f(s, dict, memo));
        }
        return ans;
    }

    int f(String latter, Set<String> dict, Map<String, Integer> memo) {
        if (memo.containsKey(latter)) {
            return memo.get(latter);
        }
        int ans = 1;
        for (int i = 0; i < latter.length(); i++) {
            String former = latter.substring(0, i) + latter.substring(i + 1, latter.length());
            if (dict.contains(former)) {
                ans = Math.max(ans, 1 + f(former, dict, memo));
            }
        }
        memo.put(latter, ans);
        return ans;
    }
}
