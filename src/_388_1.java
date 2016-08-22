/**
 * LeetCode 388 - Longest Absolute File Path
 * <p>
 * Recursive Solution
 */
public class _388_1 {
    char[] s;
    int ans = 0, ptr = 0;

    private int peekLevel() {
        int cnt = 0;
        for (int i = ptr; i < s.length && s[i] == '\t'; i++, cnt++) ;
        return cnt;
    }

    private void dfs(int currentLevel, int len) {
        boolean isFile = false;
        for (; s[ptr] != '\n'; ptr++) {
            isFile = isFile || s[ptr] == '.';
            if (s[ptr] != '\t') len++;
        }
        if (isFile) ans = Math.max(ans, len);
        ptr++; // skip '\n'
        len++; // append a '/'

        while (ptr < s.length && peekLevel() == currentLevel + 1) dfs(currentLevel + 1, len);  // recur on its children
    }

    public int lengthLongestPath(String input) {
        if (!input.endsWith("\n")) input += "\n";
        this.s = input.toCharArray();
        ans = ptr = 0;
        while (ptr < s.length) dfs(0, 0);
        return ans;
    }
}