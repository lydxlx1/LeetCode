/**
 * LeetCode 280 - Wiggle Sort
 * <p>
 * One-pass Solution
 */
public class _280 {
    public void wiggleSort(int[] nums) {
        boolean isLe = true;
        for (int i = 0; i + 1 < nums.length; i++, isLe = !isLe) {
            if ((isLe && nums[i] > nums[i + 1]) || (!isLe && nums[i] < nums[i + 1])) {
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            }
        }
    }
}