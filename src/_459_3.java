/**
 * LeetCode 459 - Repeated Substring Pattern
 * <p>
 * O(n)-time solution via Miller-Rabin
 */
public class _459_3 {
    public boolean repeatedSubstringPattern(String s) {
        long B = 29, M = 1_000_000_009, target = 0, pow = 1;
        for (int i = 0; i < s.length(); i++) target = (target * B + s.charAt(i) - 'a' + 1) % M;
        for (int i = 0; i < s.length() - 1; i++) pow = pow * B % M;

        long current = target;
        for (int i = 0; i < s.length() - 1; i++) {
            int ch = s.charAt(i) - 'a' + 1;
            current = ((current - ch * pow % M + M) * B + ch) % M;
            if (target == current) return true;
        }
        return false;
    }
}