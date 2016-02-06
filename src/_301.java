import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode 301 - Remove Invalid Parentheses
 *
 * Backtrack
 *
 * Though backtrack method does not provide any theoretical guarantee, it performs prettry well in practice.
 */
public class _301 {

    Set<String> ans;

    private void dfs(String s, String buffer, int t, int left, int right, int balance) {
        if (left < 0 || right < 0 || balance < 0 || left + right > s.length() - t) return;

        if (t == s.length()) {
            if (balance == 0 && left == 0 && right == 0) ans.add(buffer);
        } else {
            char ch = s.charAt(t);
            if (ch == '(') {
                dfs(s, buffer, t + 1, left - 1, right, balance);
                dfs(s, buffer + ch, t + 1, left, right, balance + 1);
            } else if (ch == ')') {
                dfs(s, buffer, t + 1, left, right - 1, balance);
                dfs(s, buffer + ch, t + 1, left, right, balance - 1);
            } else {
                dfs(s, buffer + ch, t + 1, left, right, balance);
            }
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        ans = new HashSet<>();
        int right = 0, balance = 0;
        for (char ch : s.toCharArray())
            if (ch == '(') balance++;
            else if (ch == ')') {
                balance--;
                if (balance < 0) {
                    right++;
                    balance++;
                }
            }
        dfs(s, "", 0, balance, right, 0);
        return new ArrayList(ans);
    }
}