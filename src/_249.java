import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 249 - Group Shifted Strings
 * <p>
 * Keyed-by Operation
 */
public class _249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            StringBuilder builder = new StringBuilder();
            if (!string.isEmpty()) {
                int offset = string.charAt(0);
                for (int i = 0; i < string.length(); i++) {
                    char ch = string.charAt(i);
                    builder.append((char) (ch - offset + 26) % 26 + 'a');
                }
                String key = builder.toString();
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(string);
            }
        }
        return new ArrayList<>(map.values());
    }
}