import java.util.Arrays;

/**
 * LeetCode 567 - Permutation in String
 * <p>
 * Sliding-window
 */
public class _567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] f = new int[128], g = new int[128];
        for (char ch : s1.toCharArray())
            f[ch]++;
        for (int i = 0; i < s2.length(); i++) {
            if (i >= s1.length())
                g[s2.charAt(i - s1.length())]--;
            g[s2.charAt(i)]++;
            if (Arrays.equals(f, g)) return true;
        }
        return false;
    }
}