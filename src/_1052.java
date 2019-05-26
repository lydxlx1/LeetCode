/**
 * LeetCode 1052 -  Grumpy Bookstore Owner
 *
 * Sliding window
 */
public class _1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int base = 0;
        int n = grumpy.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                base += customers[i];
            }
        }
        int cnt = 0, ans = 0;
        for (int left = 0, right = 0; right < n; right++) {
            cnt += grumpy[right] == 1 ? customers[right] : 0;
            if (left <= right && right - left + 1 > X) {
                cnt -= grumpy[left] == 1 ? customers[left] : 0;
                left++;
            }
            ans = Math.max(ans, base + cnt);
        }
        return ans;
    }
}
