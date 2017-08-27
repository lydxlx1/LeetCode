/**
 * LeetCode 665 - Non-decreasing Array
 * <p>
 * Greedy
 */
class _665 {
    public boolean checkPossibility(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                // We must either reduce nums[i - 1] or increase nums[i]

                int backup = nums[i - 1];
                nums[i - 1] = i - 2 >= 0 ? nums[i - 2] : Integer.MIN_VALUE;
                if (isSorted(nums)) {
                    return true;
                }
                nums[i - 1] = backup;

                nums[i] = i + 1 < nums.length ? nums[i + 1] : Integer.MAX_VALUE;
                return isSorted(nums);
            }
        }
        return true;
    }

    private boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i - 1] > a[i])
                return false;
        return true;
    }
}