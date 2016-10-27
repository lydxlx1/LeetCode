/**
 * LeetCode 186 - Reverse Words in a String II
 * <p>
 * In-place solution
 */
public class _186 {
    private void reverse(char[] s, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }

    public void reverseWords(char[] s) {
        for (int i = 0, j = 0; i < s.length; )
            if (s[i] == ' ') i++;
            else {
                for (j = i + 1; j < s.length && s[j] != ' '; j++) ;
                reverse(s, i, j - 1);
                i = j;
            }
        reverse(s, 0, s.length - 1);
    }
}