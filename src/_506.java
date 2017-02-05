import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * LeetCode 506 - Relative Ranks
 * <p>
 * Sorting
 */
public class _506 {

    public String[] findRelativeRanks(int[] nums) {
        Integer[] whoRankAt = IntStream.range(0, nums.length).boxed().sorted((u, v) -> Integer.compare(nums[u], nums[v]) * -1).toArray(Integer[]::new);
        String[] res = new String[nums.length];
        for (int i = 0; i < whoRankAt.length; i++)
            res[whoRankAt[i]] = i <= 2 ? new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"}[i] : "" + (i + 1);
        return res;
    }

    public static void main(String[] args) {
        _506 sol = new _506();
        System.out.println(Arrays.toString(sol.findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }
}
