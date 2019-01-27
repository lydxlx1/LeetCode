import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * LeetCode 981 - Time Based Key-Value Store
 *
 * HashMap + TreeMap
 */
public class _981 {

    Map<String, TreeMap<Integer, String>> map;

    public _981() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
