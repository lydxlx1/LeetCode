/**
 * LeetCode 917 - Reverse Only Letters
 *
 * Two-pointer approach
 */
public class _917 {

    public String reverseOnlyLetters(String S) {
        char[] str = S.toCharArray();
        for (int i = 0, j = str.length - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetter(str[i])) {
                i++;
            }
            while (i < j && !Character.isLetter(str[j])) {
                j--;
            }
            if (i <= j) {
                char tmp = str[i];
                str[i] = str[j];
                str[j] = tmp;
            }
        }
        return String.copyValueOf(str);
    }

    public static void main(String[] args) {
        _917 sol = new _917();
    }
}

