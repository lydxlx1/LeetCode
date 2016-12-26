import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 163 - Missing Ranges
 * <p>
 * Be careful to integer overflow
 */
public class _163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        class Helper {
            public String rangeToString(long l, long r) {
                if (l == r) return "" + l;
                else return l + "->" + r;
            }
        }
        Helper helper = new Helper();

        List<String> list = new ArrayList<>();
        if (nums == null || nums.length <= 0) list.add(helper.rangeToString(lower, upper));
        else {
            Arrays.sort(nums);
            long pre = lower - 1L;
            for (int i = 0; i < nums.length; pre = nums[i], i++)
                if (nums[i] - pre >= 2) list.add(helper.rangeToString(pre + 1L, nums[i] - 1L));
            if (pre + 1L <= upper) list.add(helper.rangeToString(pre + 1L, upper));
        }
        return list;
    }
}