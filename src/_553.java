import java.util.StringJoiner;

/**
 * LeetCode 553 - Optimal Division
 * <p>
 * Tricky problem. Just need to observe the pattern:
 * 1. a_1
 * 2. a_1 / a_2
 * 3. a_1 / (a_2 / ... / a_n)
 * <p>
 * If each a_i is no longer an integer but still positive, the problem can be solved by DP.
 */
public class _553 {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) return "" + nums[0];
        if (nums.length == 2) return nums[0] + "/" + nums[1];

        StringJoiner joiner = new StringJoiner("/");
        for (int i = 1; i < nums.length; i++)
            joiner.add("" + nums[i]);
        return String.format("%d/(%s)", nums[0], joiner.toString());
    }
}