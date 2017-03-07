/**
 * LeetCode 459 - Repeated Substring Pattern
 * <p>
 * O(n)-time solution via KMP
 */
public class _459_4 {
    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        next[0] = -1;
        for (int i = 1, j; i < next.length; i++) {
            for (j = next[i - 1]; j != -1 && s.charAt(j + 1) != s.charAt(i); j = next[j]) ;
            next[i] = s.charAt(j + 1) == s.charAt(i) ? j + 1 : -1;
        }
        int n = next.length;
        return next[n - 1] != -1 && n % (n - (next[n - 1] + 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new _459_4().repeatedSubstringPattern("abcabcabcabc"));
    }
}