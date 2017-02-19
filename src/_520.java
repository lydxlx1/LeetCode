/**
 * LeetCode 520 - Detect Capital
 * <p>
 * 1-Line solution
 */
public class _520 {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }
}


