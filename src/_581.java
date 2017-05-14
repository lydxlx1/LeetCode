import java.util.stream.IntStream;

/**
 * LeetCode 581 - Shortest Unsorted Continuous Subarray
 */
public class _581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = IntStream.of(nums).sorted().toArray();
        int left = 0, right = nums.length - 1;
        while (left <= right)
            if (nums[left] == sorted[left])
                left++;
            else if (nums[right] == sorted[right])
                right--;
            else break;
        return Math.max(right - left + 1, 0);
    }
}