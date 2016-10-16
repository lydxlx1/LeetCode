import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 422 - Valid Word Square
 * <p>
 * Brute-force
 */
public class _422 {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) return true;
        int n = words.size();
        for (String s : words) n = Math.max(n, s.length());
        if (n > words.size()) return false;

        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (String s : words)
                if (s.length() >= i + 1) builder.append(s.charAt(i));
            if (!words.get(i).equals(builder.toString())) return false;
        }
        return true;
    }
}