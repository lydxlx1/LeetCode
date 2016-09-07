import java.util.Random;

/**
 * LeetCode 136 - Single Number
 *
 * Using randomized partition
 */
public class _136_1 {
    Random rand = new Random();

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public int singleNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int index = rand.nextInt(right - left + 1) + left;
            swap(nums, index, right);

            int mid = left - 1;
            for (int i = left; i <= right; i++)
                if (nums[i] <= nums[right]) swap(nums, ++mid, i);

            if ((mid - left + 1) % 2 == 1) right = mid;
            else left = mid + 1;
        }
        return nums[left];
    }
}