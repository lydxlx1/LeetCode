/**
 * LeetCode 246 - Strobogrammatic Number
 * <p>
 * Brute-force
 */
public class _246 {
    private char map(char ch) {
        if (ch == '6') return '9';
        else if (ch == '9') return '6';
        else if (ch == '1') return '1';
        else if (ch == '8') return '8';
        else if (ch == '0') return '0';
        else return 0;
    }

    public boolean isStrobogrammatic(String num) {
        char[] s = num.toCharArray();
        for (char ch : s) if (map(ch) == 0) return false;
        for (int i = 0, j = s.length - 1; i <= j; i++, j--)
            if (map(s[i]) != s[j]) return false;
        return true;
    }
}