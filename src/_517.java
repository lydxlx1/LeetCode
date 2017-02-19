import java.util.stream.IntStream;

/**
 * LeetCode 517 - Super Washing Machines
 * <p>
 * A tricky questions.
 * Please refer to the following for a detailed explanation.
 * https://discuss.leetcode.com/topic/79923/c-16ms-o-n-solution/2
 */
public class _517 {
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length <= 0) return 0;
        int sum = IntStream.of(machines).sum();
        if (sum % machines.length != 0) return -1;
        int per = sum / machines.length, ans = 0;
        for (int i = 0, prefixSum = 0; i < machines.length; i++) {
            int toLeft = i * per - prefixSum;
            int toRight = (machines.length - i - 1) * per - (sum - prefixSum - machines[i]);
            ans = Math.max(ans, Math.max(toLeft, 0) + Math.max(toRight, 0));
            prefixSum += machines[i];
        }
        return ans;
    }
}


