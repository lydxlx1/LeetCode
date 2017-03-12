import java.util.*;

/**
 * LeetCode 527 - Word Abbreviation
 * <p>
 * We first shorten each string in the most naive way.
 * If more than one strings are mapped to the same key, we then extract their common prefix and recursively
 * solve the problem.
 */
public class _527 {

    private String shorten(String s) {
        if (s.length() <= 3) return s;
        else return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
    }

    private String commonPrefix(List<String> dict, List<Integer> indices) {
        String base = dict.get(indices.get(0));
        for (int len = 0; len < base.length(); len++) {
            for (int i = 1; i < indices.size(); i++) {
                String other = dict.get(indices.get(i));
                if (len >= other.length() || base.charAt(len) != other.charAt(len)) return base.substring(0, len);
            }
        }
        return base;
    }

    public List<String> wordsAbbreviation(List<String> dict) {
        if (dict.isEmpty()) return dict;

        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < dict.size(); i++) {
            String key = shorten(dict.get(i));
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(i);
        }
        while (map.size() < dict.size()) {
            Map<String, List<Integer>> map1 = new HashMap<>();
            for (String key : map.keySet()) {
                List<Integer> list = map.get(key);
                if (list.size() > 1) {
                    String prefix = commonPrefix(dict, list);
                    for (int id : list) {
                        String s = dict.get(id);
                        String newKey = prefix + shorten(s.substring(prefix.length()));
                        map1.putIfAbsent(newKey, new ArrayList<>());
                        map1.get(newKey).add(id);
                    }
                } else {
                    map1.put(key, list);
                }
            }

            map = map1;
        }

        List<String> res = new ArrayList<>(dict.size());
        for (int i = 0; i < dict.size(); i++) res.add(""); // place-holders
        for (String s : map.keySet()) res.set(map.get(s).get(0), s);
        return res;
    }

    public static void main(String[] args) {
        _527 sol = new _527();
        System.out.println(sol.wordsAbbreviation(Arrays.asList("like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion")));
    }
}
