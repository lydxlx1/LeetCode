import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 471 - Encode String with Shortest Length
 */
public class _471 {
    Map<String, String> map = new HashMap<>();

    public String encode(String s) {
        if (map.containsKey(s)) return map.get(s);
        String ans = s;

        for (int len = 1; len < s.length(); len++) {
            String prefix = s.substring(0, len);
            String suffix = s.substring(len, s.length());

            // Option 1
            String tmp = encode(prefix) + encode(suffix);
            if (tmp.length() < ans.length()) ans = tmp;

            // Option 2
            if (s.length() % len == 0) {
                boolean ok = true;
                for (int i = 0, j = 0; i < s.length(); i++, j = (j + 1) % len)
                    if (s.charAt(i) != s.charAt(j)) {
                        ok = false;
                        break;
                    }
                if (ok) {
                    tmp = String.format("%d[%s]", s.length() / len, encode(prefix));
                    if (tmp.length() < ans.length()) ans = tmp;
                }
            }
        }

        map.put(s, ans);
        return ans;
    }
}