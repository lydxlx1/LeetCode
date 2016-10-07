import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 293 - Flip Game
 * <p>
 * Brute-force
 */
public class _293 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length - 1; i++)
            if (str[i] == '+' && str[i + 1] == '+') {
                str[i] = str[i + 1] = '-';
                list.add(String.copyValueOf(str));
                str[i] = str[i + 1] = '+';
            }
        return list;
    }
}