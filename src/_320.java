import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 320 - Generalized Abbreviation
 * <p>
 * Bit manipulation
 */
public class _320 {
    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<>(1 << word.length());
        for (int bit = 0; bit < 1 << word.length(); bit++) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0, j = 0; i < word.length(); ) {
                if ((bit & (1 << i)) == 0) builder.append(word.charAt(i++));
                else {
                    for (j = i + 1; j < word.length() && (bit & (1 << j)) != 0; j++) ;
                    builder.append(j - i);
                    i = j;
                }
            }
            list.add(builder.toString());
        }
        return list;
    }
}