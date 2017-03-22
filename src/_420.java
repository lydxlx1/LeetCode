import java.util.function.Predicate;

/**
 * LeetCode 420 - Strong Password Checker
 * <p>
 * Slow, long, complicated, but correct...
 */
public class _420 {

    private int cnt(String s, Predicate<Character> p) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++)
            if (p.test(s.charAt(i))) cnt++;
        return cnt;
    }

    private int digitCnt(String s) {
        return cnt(s, Character::isDigit);
    }

    private int lowerCnt(String s) {
        return cnt(s, Character::isLowerCase);
    }

    private int upperCnt(String s) {
        return cnt(s, Character::isUpperCase);
    }

    private char nextChar(String s) {
        if (digitCnt(s) == 0) return '0';
        if (lowerCnt(s) == 0) return 'a';
        if (upperCnt(s) == 0) return 'A';
        for (char ch = 'a'; ch <= 'z'; ch++) if (!s.contains("" + ch)) return ch;
        for (char ch = 'A'; ch <= 'Z'; ch++) if (!s.contains("" + ch)) return ch;
        for (char ch = '0'; ch <= '9'; ch++) if (!s.contains("" + ch)) return ch;
        return 'a';
    }

    private boolean isValid(String s) {
        if (s.length() < 6 || s.length() > 20) return false;
        if (digitCnt(s) == 0 || lowerCnt(s) == 0 || upperCnt(s) == 0) return false;
        for (int i = 0; i + 3 <= s.length(); i++)
            if (s.charAt(i + 1) == s.charAt(i) && s.charAt(i + 2) == s.charAt(i)) return false;
        return true;
    }

    int ans = Integer.MAX_VALUE;

    public int strongPasswordChecker(String s) {
        ans = Integer.MAX_VALUE;
        dfs(s, 0);
        return ans;
    }

    private void dfs(String s, int steps) {
        if (steps >= ans) return;
        if (isValid(s)) {
            ans = steps;
        } else {
            for (int i = 0, j; i < s.length(); ) {
                for (j = i + 1; j < s.length() && s.charAt(i) == s.charAt(j); j++) ;
                if (j - i >= 3) {
                    // remove
                    dfs(s.substring(0, i + 2) + s.substring(i + 3), steps + 1);

                    // replace
                    dfs(s.substring(0, i + 2) + nextChar(s) + s.substring(i + 3), steps + 1);

                    // add
                    if (s.length() < 6)
                        dfs(s.substring(0, i + 2) + nextChar(s) + s.substring(i + 2), steps + 1);

                    return;
                }
                i = j;
            }

            // No consecutive three same letters any more
            if (s.length() < 6) dfs(nextChar(s) + s, steps + 1);
            else {
                String replacement = s.length() > 20 ? "" : "" + nextChar(s);
                if (digitCnt(s) > 1) dfs(s.replaceFirst("[0-9]", replacement), steps + 1);
                else if (lowerCnt(s) > 1) dfs(s.replaceFirst("[a-z]", replacement), steps + 1);
                else if (upperCnt(s) > 1) dfs(s.replaceFirst("[A-Z]", replacement), steps + 1);
                else dfs(s.replaceFirst("[^0-9a-zA-Z]", replacement), steps + 1);
            }
        }
    }

    public static void main(String[] args) {
        _420 sol = new _420();
        System.out.println(sol.strongPasswordChecker("aaa111"));
    }
}
