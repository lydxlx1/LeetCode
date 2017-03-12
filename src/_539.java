import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 539 - Minimum Time Difference
 * <p>
 * Sorting
 * Don't forget to compare the circular difference between the smallest and the largest element.
 */
public class _539 {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> a = new ArrayList<>(timePoints.size() + 1);
        for (String s : timePoints)
            a.add(60 * Integer.parseInt(s.split(":")[0]) + Integer.parseInt(s.split(":")[1]));
        Collections.sort(a);
        a.add(a.get(0));

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < a.size(); i++) {
            int diff = Math.abs(a.get(i) - a.get(i - 1));
            ans = Math.min(ans, Math.min(diff, 24 * 60 - diff));
        }
        return ans;
    }
}
