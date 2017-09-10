import java.util.stream.IntStream;

/**
 * LeetCode 673 - Number of Longest Increasing Subsequence
 * <p>
 * O(n^2)-time DP
 */
public class _673 {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        final int n = nums.length;
        int[] len = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (len[j] + 1 == len[i]) {
                        cnt[i] += cnt[j];
                    } else {
                        continue;
                    }
                }
            }
        }
        int maxLen = IntStream.of(len).max().getAsInt();
        return IntStream.range(0, n).filter(i -> len[i] == maxLen).map(i -> cnt[i]).sum();
    }
}
