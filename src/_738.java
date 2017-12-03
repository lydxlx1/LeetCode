/**
 * LeetCode 738 - Monotone Increasing Digits
 * <p>
 * Greedy
 * <p>
 * I think the following two test cases should give enough hints:
 * <p>
 * Input: N = 332
 * Output: 299
 * <p>
 * Input: N = 100
 * Output: 99
 */
public class _738 {
    public int monotoneIncreasingDigits(int N) {
        char[] s = ("" + N).toCharArray();
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i] > s[i + 1]) {
                char val = s[i];
                for (int j = i; j >= 0; j--)
                    if (s[j] == val) {
                        s[j] = (char) (val - 1);
                        if (j + 1 < s.length) {
                            s[j + 1] = '9';
                        }
                    }

                for (int j = i + 1; j < s.length; j++)
                    s[j] = '9';
                break;
            }
        }

        int ans = 0;
        for (char ch : s) {
            ans = ans * 10 + ch - '0';
        }
        return ans;
    }
}