/**
 * LeetCode 464 - Can I Win
 * <p>
 * DP + Game Theory
 * <p>
 * It is crucial to observe that we only need 2^maxChoosableInteger to represent the state, i.e.,
 * the DP state is independent with desireTotal
 */
public class _464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;

        boolean[] f = new boolean[1 << maxChoosableInteger];
        for (int avaiableNums = 0; avaiableNums < f.length; avaiableNums++) {
            int remainingTotal = desiredTotal;
            for (int i = 0; i < maxChoosableInteger; i++)
                if (((1 << i) & avaiableNums) == 0) remainingTotal -= i + 1;
            if (remainingTotal <= 0) continue; // Always lose

            for (int i = 0; i < maxChoosableInteger; i++)
                if (((1 << i) & avaiableNums) != 0 && !f[avaiableNums ^ (1 << i)]) {
                    f[avaiableNums] = true;
                    break;
                }
        }

        return f[(1 << maxChoosableInteger) - 1];
    }
}