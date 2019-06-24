/**
 * LeetCode - Statistics from a Large Sample
 */
public class StatisticsFromALargeSample {

    public double[] sampleStats(int[] count) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = 0;
        int mode = -1;
        int maxF = 0;
        long sum = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
                sum += (long) count[i] * i;
                if (count[i] > maxF) {
                    mode = i;
                    maxF = count[i];
                }
            }
            n += count[i];
        }

        double mean = 1.0 * sum / n;
        double median;
        if (n % 2 == 1) {
            median = kthElement(count, n / 2 + 1);
        } else {
            median = (0.0 + kthElement(count, n / 2) + kthElement(count, n / 2 + 1)) / 2.0;
        }
        return new double[]{min, max, mean, median, mode};
    }

    int kthElement(int[] count, int k) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= k) {
                return i;
            } else {
                k -= count[i];
            }
        }
        throw new RuntimeException("");
    }
}
