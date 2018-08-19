import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LeetCode 890 - Find and Replace Pattern
 * <p>
 * Greedy
 */
public class _890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<Integer> target = map(pattern);
        return Stream.of(words).filter(s -> target.equals(map(s))).collect(Collectors.toList());
    }

    /**
     * This function encodes (in a greedy fashion) a string s into its unique canonical format.
     */
    List<Integer> map(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>(s.length());
        int index = 0;

        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, index);
                index++;
            }
            res.add(map.get(ch));
        }
        return res;
    }
}

