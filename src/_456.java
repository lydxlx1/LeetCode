import java.util.TreeSet;

/**
 * LeetCode 456 - 123 Pattern
 * <p>
 * O(n log n) solution using BST
 * <p>
 * For each fixed a_j, we need to know
 * 1. the smallest element to the left of a_j;
 * 2. the largest element, which is less than a_j, to the right of a_j;
 * 3. whether the number in (1) is less than the one found in (2).
 */
public class _456 {
    public boolean find132pattern(int[] nums) {
        int[] minToTheLeft = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            minToTheLeft[i] = min;
            min = Math.min(min, nums[i]);
        }

        TreeSet<Integer> treeToTheRight = new TreeSet<>();
        for (int i = nums.length - 1; i >= 1; i--) {
            Integer right;
            if ((right = treeToTheRight.lower(nums[i])) != null && minToTheLeft[i] < right && right < nums[i])
                return true;
            treeToTheRight.add(nums[i]);
        }
        return false;
    }
}
