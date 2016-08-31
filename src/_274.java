/**
 * LeetCode 274 - H-Index
 *
 * O(n) Counting Sort
 */
public class _274 {
    public int hIndex(int[] citations) {
        int[] cnt = new int[citations.length + 1];
        for (int i : citations) cnt[Math.min(i, cnt.length - 1)]++;
        for (int i = cnt.length - 1, sum = 0; i >= 0; i--) {
            sum += cnt[i];
            if (sum >= i) return i;
        }
        return 0;
    }
}