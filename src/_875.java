/**
 * LeetCode 875 - Koko Eating Bananas
 * <p>
 * Binary Search
 */
public class _875 {

    public int minEatingSpeed(int[] piles, int H) {
        if (piles.length == 0) return 0;

        int left = 0, right = 2000000000;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isok(piles, H, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean isok(int[] piles, int H, int K) {
        if (K == 0) return false;
        long cnt = 0;
        for (int pile : piles) {
            cnt += (0L + pile + K - 1) / K;
            if (cnt > H) return false;
        }
        return true;
    }
}

