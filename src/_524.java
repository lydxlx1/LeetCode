import java.util.List;

import static java.util.Comparator.comparingInt;

/**
 * LeetCode 524 - Longest Word in Dictionary through Deleting
 * <p>
 * We can greedily test whether a string is a subsequence of another.
 */
public class _524 {

    public String findLongestWord(String s, List<String> d) {
        return d.stream().filter(dd -> {
            int i = 0, j = 0;
            while (i < s.length() && j < dd.length()) {
                if (s.charAt(i) == dd.charAt(j)) j++;
                i++;
            }
            return j >= dd.length();
        }).min(comparingInt((String u) -> u.length()).reversed().thenComparing(String::compareTo)).orElse("");
    }
}
