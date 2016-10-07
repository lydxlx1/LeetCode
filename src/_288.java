import java.util.*;

/**
 * LeetCode 288 - Unique Word Abbreviation
 * <p>
 * Please read the problem statement carefully!
 * Also, we only need to store at most two Strings per each key.
 */
public class _288 {
    private String map(String s) {
        if (s.length() <= 2) return s;
        else return String.format("%c%d%c", s.charAt(0), s.length() - 2, s.charAt(s.length() - 1));
    }

    Map<String, Set<String>> map;

    public _288(String[] dictionary) {
        map = new HashMap<>();
        for (String s : dictionary) {
            String key = map(s);
            map.putIfAbsent(key, new HashSet<>());
            if (map.get(key).size() < 2) map.get(key).add(s);
        }
    }

    public boolean isUnique(String word) {
        String key = map(word);
        return !map.containsKey(key) || new ArrayList<>(map.get(key)).equals(Arrays.asList(word));
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
