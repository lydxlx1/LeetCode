import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 438 - Find All Anagrams in a String
 * <p>
 * Sliding Window
 */
public class _438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        char[] actual = new char[26];
        char[] expected = new char[26];

        for (char ch : p.toCharArray()) expected[ch - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            actual[s.charAt(i) - 'a']++;
            if (i - p.length() >= 0) actual[s.charAt(i - p.length()) - 'a']--;

            boolean ok = true;
            for (int j = 0; j < 26; j++)
                if (actual[j] != expected[j]) {
                    ok = false;
                    break;
                }
            if (ok) ans.add(i - p.length() + 1);
        }
        return ans;
    }
}
