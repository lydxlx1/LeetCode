import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 442 Find All Duplicates in an Array
 * <p>
 * O(n) runtime and O(1) extra space
 * Mod Trick
 */
public class _442 {
    public List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) nums[i]--;

        // Every number now is in the range of [0, n)
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i] % nums.length;
            nums[val] += nums.length;
        }

        // Now, for each nums[i], we have the following three cases
        // 1. If 0 <= nums[i] < n, then i does not appear in the array.
        // 2. If n <= nums[i] < 2n, then i appears exactly once in the array.
        // 3. If 2n <= nums[i] < 3n, then i appears exactly twice in the array.
        // This pattern can be generalized to find all the numbers that appear exactly k times.

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] >= 2 * nums.length) list.add(i + 1);

        // Uncomment these if one wants to restock the original array.
//        for (int i=0; i<nums.length; i++)
//            nums[i] = nums[i] % nums.length + 1;

        return list;
    }
}