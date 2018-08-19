import java.util.*;

/**
 * LeetCode 888 - Uncommon Words from Two Sentences
 */
public class _884 {

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> dict = new HashMap<>();
        for (String s : A.trim().split("[ ]+")) {
            if (s.length() > 0) {
                dict.put(s, dict.getOrDefault(s, 0) + 1);
            }
        }
        for (String s : B.trim().split("[ ]+")) {
            if (s.length() > 0) {
                dict.put(s, dict.getOrDefault(s, 0) + 1);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String s : dict.keySet()) {
            if (dict.get(s) == 1) {
                ans.add(s);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}

