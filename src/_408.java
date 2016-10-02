/**
 * LeetCode 408 - Valid Word Abbreviation
 *
 * Brute-force
 */
public class _408 {
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