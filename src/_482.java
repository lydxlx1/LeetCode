import java.util.StringJoiner;

/**
 * LeetCode 482 - License Key Formatting
 * <p>
 * Short solution
 */
public class _482 {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "");
        StringJoiner joiner = new StringJoiner("-");
        for (int i = S.length() - 1; i >= 0; ) {
            StringBuilder builder = new StringBuilder();
            for (int j = i; j > i - K && j >= 0; j--)
                builder.append(Character.toUpperCase(S.charAt(j)));
            i -= K;
            joiner.add(builder.toString());
        }
        return new StringBuilder(joiner.toString()).reverse().toString();
    }
}