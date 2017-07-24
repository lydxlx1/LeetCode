import java.util.stream.IntStream;

/**
 * LeetCode 645 - Set Mismatch
 * <p>
 * Counting Sort
 */
public class _645 {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        for (int num : nums)
            cnt[num]++;
        int twice = IntStream.rangeClosed(1, n).filter(i -> cnt[i] == 2).findFirst().getAsInt();
        int miss = IntStream.rangeClosed(1, n).filter(i -> cnt[i] == 0).findFirst().getAsInt();
        return new int[]{twice, miss};
    }
}