import java.util.*;


/**
 * LeetCode 820 - Short Encoding Words
 * <p>
 * Sort by non-increasing length and then greedy
 */
public class _820 {

    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        StringBuilder builder = new StringBuilder();
        List<String> distinctWords = new ArrayList<>(set);
        Collections.sort(distinctWords, Comparator.<String>comparingInt(word -> word.length()).reversed());

        for (String word : distinctWords) {
            if (set.contains(word)) {
                builder.append(word);
                builder.append("#");
                for (int i = 0; i < word.length(); i++) {
                    String suffix = word.substring(i);
                    set.remove(suffix);
                }
            }
        }

        return builder.toString().length();
    }
}

