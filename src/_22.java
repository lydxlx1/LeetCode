import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 22 - Generate Parentheses
 * <p>
 * DP approach
 * <p>
 * To avoid generating duplicate strings, we enumerate the first part which is surrounded by a pair of (), i.e.
 * <p>
 * ( [subprob 1] ) [subprob 2]
 * <p>
 * Note that both sub problems can be empty, i.e., empty string.
 */
public class _22 {

    static Map<Integer, List<String>> map = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        if (map.containsKey(n)) return map.get(n);
        List<String> ans = new ArrayList<>();
        if (n == 0) ans.add("");
        else {
            for (int i = 1; i <= n; i++) {
                for (String l : generateParenthesis(i - 1))
                    for (String r : generateParenthesis(n - i)) // will be
                        ans.add(String.format("(%s)%s", l, r));
            }
        }
        map.put(n, ans);
        return ans;
    }
}
