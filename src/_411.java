import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LeetCode 411 - Minimum Unique Word Abbreviation
 *
 * Brute-force + Pruning
 */
public class _411 {
    public String minAbbreviation(String target, String[] dictionary) {
        List<String> dict = Stream.of(dictionary).filter(s -> s.length() == target.length()).collect(Collectors.toList());
        String ans = null;
        int minLen = Integer.MAX_VALUE;
        for (int bit = 0; bit < (1 << target.length()); bit++) {
            loop:
            {
                StringBuilder builder = new StringBuilder();
                int len = 0, j = 0;
                for (int i = 0; i < target.length(); ) {
                    if (((1 << i) & bit) != 0) builder.append(target.charAt(i++));
                    else {
                        for (j = i + 1; j < target.length() && ((1 << j) & bit) == 0; j++) ;
                        builder.append(j - i);
                        i = j;
                    }
                    if (++len >= minLen) break loop;
                }
                String abbr = builder.toString();
                boolean ok = true;
                for (String word : dict)
                    if (validWordAbbreviation(word, abbr)) {
                        ok = false;
                        break;
                    }
                if (ok) {
                    minLen = len;
                    ans = abbr;
                }
            }
        }
        return ans;
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length())
            if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0') return false;
                int num = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) num = num * 10 + abbr.charAt(j++) - '0';
                i += num;
            } else {
                if (word.charAt(i++) != abbr.charAt(j++)) return false;
            }
        return i == word.length() && j == abbr.length();
    }
}
