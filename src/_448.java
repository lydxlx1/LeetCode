import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 448 - Find All Numbers Disappeared in an Array
 * <p>
 * Cycle-finding algorithm
 * O(n) time and O(1) extra space
 */
public class _448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) nums[i]--; // To avoid confusions
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i) {
                int needle = nums[i];
                while (nums[needle] != needle) {
                    int newNeedle = nums[needle];
                    nums[needle] = needle;
                    needle = newNeedle;
                }
            }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i) list.add(i + 1);
        return list;
    }
}