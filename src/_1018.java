import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 1018 - Binary Prefix Divisible By 5
 *
 * Math
 */
public class _1018 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>(A.length);
        int sum = 0;
        for (int bit : A) {
            sum = (sum * 2 + bit) % 5;
            res.add(sum == 0);
        }
        return res;
    }
}

