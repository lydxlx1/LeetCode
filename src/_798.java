/**
 * LeetCode 798 - Smallest Rotation with Highest Score
 * <p>
 * Sliding window
 */
public class _798 {

    public int bestRotation(int[] A) {
        int[] cnt = new int[2 * A.length + 10];
        int score = 0;

        for (int i = 0; i < A.length; i++) {
            int diff = i - A[i];
            if (diff >= 0) {
                cnt[diff]++;
                score++;
            }
        }
        int maxScore = score, K = 0, ptr = 0;

        for (int i = 1; i < A.length; i++) {
            // Consider the rotated string
            // A[i], A[i + 1], A[i + 2], ..., A[i - 1]

            score -= cnt[ptr];

            ptr++;
            int diff = (A.length - 1) - A[i - 1];
            if (diff >= 0) {
                cnt[diff + ptr]++;
                score++;
            }

            if (score > maxScore) {
                maxScore = score;
                K = i;
            }
        }

        return K;
    }
}
