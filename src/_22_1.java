import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 22 - Generate Parentheses
 * <p>
 * Recursion
 */
public class _22_1 {

    void dfs(int balance, String s, int n, List<String> list) {
        if (balance < 0) return;
        if (s.length() == 2 * n) {
            if (balance == 0) list.add(s);
        } else {
            dfs(balance + 1, s + "(", n, list);
            dfs(balance - 1, s + ")", n, list);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, "", n, res);
        return res;
    }
}
