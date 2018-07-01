/**
 * LeetCode 860 - Lemonade Change
 * <p>
 * Greedy
 */
public class _860 {

    public boolean lemonadeChange(int[] bills) {
        int[] cnt = new int[21];
        for (int bill : bills) {
            cnt[bill]++;
            int change = bill - 5;
            for (int i : new int[]{10, 5}) {
                while (change >= i && cnt[i] > 0) {
                    change -= i;
                    cnt[i]--;
                }
            }
            if (change > 0) {
                return false;
            }
        }
        return true;
    }
}

