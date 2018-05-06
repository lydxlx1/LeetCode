import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * LeetCode 830 - Positions of Large Groups
 * <p>
 * Pretty straightforward solution
 */
public class _830 {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < S.length(); ) {
            int j = i + 1;
            for (; j < S.length(); j++) {
                if (S.charAt(j) != S.charAt(i)) {
                    break;
                }
            }

            if (j - i >= 3) {
                res.add(Arrays.asList(i, j - 1));
            }
            i = j;
        }

        return res;
    }
}

