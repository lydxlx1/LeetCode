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
            int passToLeft = Math.max(0, toLeft);
            int passToRight = Math.max(0, toRight);
            int recFromLeft = Math.max(0, -toLeft);
            int recFromRight = Math.max(0, -toRight);
            ans = Math.max(ans, Math.max(passToLeft + passToRight, Math.max(recFromLeft, recFromRight)));
            prefixSum += machines[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _517().findMinMoves(new int[]{0, 3, 0}));
    }
}


