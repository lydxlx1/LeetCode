import java.util.StringJoiner;

/**
 * LeetCode 557 - Reverse Words in a String III
 * <p>
 * Brute-force
 */
public class _557 {

    public String reverseWords(String s) {
        StringJoiner join = new StringJoiner(" ");
        for (String str : s.split(" "))
            join.add(new StringBuilder(str).reverse());
        return join.toString();
    }
}
