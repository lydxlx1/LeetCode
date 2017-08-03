/**
 * LeetCode 540 - Single Element in a Sorted Array
 * <p>
 * Binary Search
 */
public class _540 {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (right - left + 1 > 1) {
            int mid = (left + right) / 2;
            int cnt = 1;

            if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                if ((mid - 1 - left) % 2 == 1)
                    right = mid - 2;
                else
                    left = mid + 1;
            } else if (mid + 1 < nums.length && nums[mid + 1] == nums[mid]) {
                if ((right - (mid + 1)) % 2 == 1)
                    left = mid + 2;
                else
                    right = mid - 1;
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }
}