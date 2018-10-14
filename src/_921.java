/**
 * LeetCode 921 - Minimum Add to Make Parentheses Valid
 */
public class _921 {

    public int minAddToMakeValid(String S) {
        int res = 0;
        int leftParam = 0;
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                leftParam++;
            } else {
                if (leftParam == 0) {
                    res++;
                } else {
                    leftParam--;
                }
            }
        }

        return res + leftParam;
    }
}

