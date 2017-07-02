import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 633 - Sum of Square Numbers
 * <p>
 * Although using more space, this is still an intersting solution...
 */
public class _633_1 {
    public boolean judgeSquareSum(int c) {
        Set<Integer> squares = new HashSet<>();
        for (int i = 0; (long) i * i <= Integer.MAX_VALUE; i++)
            squares.add(i * i);
        for (int i = 0; (long) i * i <= c; i++)
            if (squares.contains(c - i * i))
                return true;
        return false;
    }

}