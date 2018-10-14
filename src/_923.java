/**
 * LeetCode 923 - 3Sum With Multiplicity
 *
 * A counting approach
 * Care must be taken to avoid double couting.
 */
public class _923 {

    public int threeSumMulti(int[] A, int target) {
        int[] cnt = new int[111];
        for (int i : A) {
            cnt[i]++;
        }

        long res = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k >= j && k <= 100) {
                    long tmp = 1;

                    tmp *= cnt[i];
                    cnt[i]--;
                    tmp *= cnt[j];
                    cnt[j]--;
                    tmp *= cnt[k];
                    cnt[k]--;

                    if (i == j && j == k) {
                        tmp /= 6;
                    } else if (i == j || j == k) {
                        tmp /= 2;
                    }

                    res += tmp;
                    cnt[k]++;
                    cnt[j]++;
                    cnt[i]++;
                }
            }
        }

        return (int) (res % 1000000007);
    }
}

