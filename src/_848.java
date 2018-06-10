/**
 * LeetCode 848 - Shifting Letters
 * <p>
 * Suffix-sum
 */
public class _848 {

    public String shiftingLetters(String S, int[] shifts) {
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i + 1] + shifts[i]) % 26;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            builder.append(shift(S.charAt(i), shifts[i]));
        }
        return builder.toString();
    }

    char shift(char a, int x) {
        return (char) ((a - 'a' + x) % 26 + 'a');
    }
}

