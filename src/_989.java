import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 989 - Add to Array-Form of Integer
 *
 * Arithmetic Addition
 */
public class _989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int current = K;
        int i = A.length - 1;
        while (i >= 0 || current > 0) {
            if (i >= 0) {
                current += A[i];
                i--;
            }
            res.add(current % 10);
            current /= 10;
        }

        Collections.reverse(res);
        return res;
    }
}

