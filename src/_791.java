import java.util.Comparator;

/**
 * LeetCode 791 - Custom Sort String
 */
public class _791 {


    public String customSortString(String S, String T) {
        StringBuilder builder = new StringBuilder();
        T.chars().boxed().sorted(Comparator.comparingInt(ch -> S.indexOf(ch))).forEach(builder::appendCodePoint);
        return builder.toString();
    }
}
