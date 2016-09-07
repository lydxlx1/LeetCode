/**
 * LeetCode 151 - Reverse Words in a String
 */
public class _151 {
    public String reverseWords(String s) {
        String[] tokens = s.trim().split("[ ]+");
        for (int i = 0, j = tokens.length - 1; i < j; i++, j--) {
            String str = tokens[i];
            tokens[i] = tokens[j];
            tokens[j] = str;
        }
        return String.join(" ", tokens);
    }
}