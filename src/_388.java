/**
 * LeetCode 388 - Longest Absolute File Path
 *
 * Using a Stack
 */
public class _388 {


    public int lengthLongestPath(String input) {
        if (!input.endsWith("\n")) input = input + "\n";
        char[] s = input.toCharArray();
        int n = s.length;
        int[] sLen = new int[n];
        int[] sLevel = new int[n]; // in fact, we can even drop this array and use top-point instead
        int top = 0, ptr = 0, ans = 0;

        sLen[top] = -1; // since there is no leading / for an absolute path
        sLevel[top++] = -1;
        while (ptr < input.length()) {
            int currentLevel = 0;
            while (ptr < s.length && s[ptr] == '\t') {
                currentLevel++;
                ptr++;
            }
            int currentLen = 0;
            boolean isFile = false;
            while (s[ptr] != '\n') {
                currentLen++;
                isFile = isFile || s[ptr] == '.';
                ptr++;
            }
            ptr++; // skip \n
            while (top > 0 && sLevel[top - 1] >= currentLevel) top--;

            sLen[top] = sLen[top - 1] + currentLen + 1; // + 1 for /
            sLevel[top++] = currentLevel;
            if (isFile) ans = Math.max(ans, sLen[top - 1]);
        }
        return ans;
    }
}