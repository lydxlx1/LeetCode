/**
 * LeetCode 856 - Score of Parentheses
 * <p>
 * Divide-and-Conquer
 */
public class _856 {

    public int scoreOfParentheses(String S) {
        if (S.equals("()")) return 1;
        int t = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                t++;
            } else {
                t--;
                if (t == 0) {
                    if (i == S.length() - 1) {
                        return scoreOfParentheses(S.substring(1, i)) * 2;
                    } else {
                        return scoreOfParentheses(S.substring(0, i + 1)) + scoreOfParentheses(S.substring(i + 1));
                    }
                }
            }
        }
        throw new RuntimeException();
    }
}

