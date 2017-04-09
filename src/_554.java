import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 554 - Brick Wall
 * <p>
 * Compute the prefix sums for each row and compress them together.
 */
public class _554 {

    public int leastBricks(List<List<Integer>> wall) {
        int ans = wall.size(), total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i : row) {
                sum += i;
                map.putIfAbsent(sum, 0);
                map.put(sum, map.get(sum) + 1);
            }
            total = sum;
        }

        for (int key : map.keySet())
            if (key < total)
                ans = Math.min(ans, wall.size() - map.get(key));
        return ans;
    }

    public static void main(String[] args) {
        _554 sol = new _554();
    }
}
