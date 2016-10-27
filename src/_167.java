import java.util.Arrays;

/**
 * LeetCode 167 - Two Sum II - Input array is sorted
 * <p>
 * Two-pointer method
 */
public class _167 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j; )
            if (numbers[i] + numbers[j] < target) i++;
            else if (numbers[i] + numbers[j] > target) j--;
            else return new int[]{i + 1, j + 1};
        throw new RuntimeException("No solution exists for array " + Arrays.toString(numbers) + ", and target = " + target);
    }
}