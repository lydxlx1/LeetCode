import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 291 - Word Pattern II
 * <p>
 * Backtracking + Pruning
 * <p>
 * Runtime: 106ms -> 10ms
 */
public class _291_1 {

    Map<Character, Integer> charMap;
    Map<String, Integer> substringMap;
    Map<Character, String> map;
    char[] p, s;
    String str;


    private boolean dfs(int t, String cur) {
        if (t >= p.length) {
            StringBuilder builder = new StringBuilder();
            for (char ch : p) builder.append(map.get(ch));
            return builder.toString().equals(str);
        } else {
            if (map.containsKey(p[t])) {
                return cur.startsWith(map.get(p[t])) && dfs(t + 1, cur.substring(map.get(p[t]).length()));
            } else {
                for (int i = 0; i < cur.length(); i++) {
                    String sub = cur.substring(0, i + 1);
                    if (!map.values().contains(sub)) {
                        map.put(p[t], sub);
                        if (substringMap.get(sub) >= charMap.get(p[t]) && dfs(t + 1, cur.substring(sub.length())))
                            return true;
                        map.remove(p[t]);
                    }
                }
            }
            return false;
        }
    }

    public boolean wordPatternMatch(String pattern, String str) {
        map = new HashMap<>();
        substringMap = new HashMap<>();
        charMap = new HashMap<>();
        p = pattern.toCharArray();
        s = str.toCharArray();
        this.str = str;
        for (char ch : pattern.toCharArray()) {
            charMap.putIfAbsent(ch, 0);
            charMap.put(ch, charMap.get(ch) + 1);
        }
        for (int i = 0; i < str.length(); i++)
            for (int j = i; j < str.length(); j++) {
                String sub = str.substring(i, j + 1);
                substringMap.putIfAbsent(sub, 0);
                substringMap.put(sub, substringMap.get(sub) + 1);
            }
        return dfs(0, str);
    }
}