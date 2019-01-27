import java.util.Arrays;

/**
 * LeetCode 982 - Triples with Bitwise AND Equal to Zero
 *
 * DP + Lazy Evaluation
 */
public class _982 {

    public int countTriplets(int[] A) {
        int[] f = new int[1 << 16];
        Arrays.fill(f, -1);

        int ans = 0;
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A.length; j++) {
                int bit = A[i] & A[j];

                if (f[bit] == -1) {
                    f[bit] = 0;
                    for (int k : A) {
                        if ((k & bit) == 0) {
                            f[bit]++;
                        }
                    }
                }
                ans += f[A[i] & A[j]];
            }
        return ans;
    }
}

