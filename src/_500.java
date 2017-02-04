import java.util.stream.Stream;

/**
 * LeetCode 500 - Keyboard Row
 * <p>
 * 1-Line solution
 */
public class _500 {

    public String[] findWords(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }
}
