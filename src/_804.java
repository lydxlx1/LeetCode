import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 804 - Unique Morse Code Words
 */
public class _804 {

    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> transformedWords = new HashSet<>();
        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (char c : word.toCharArray()) {
                builder.append(codes[c - 'a']);
            }
            transformedWords.add(builder.toString());
        }
        return transformedWords.size();
    }
}
