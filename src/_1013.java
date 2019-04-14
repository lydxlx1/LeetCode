import java.util.stream.IntStream;

/**
 * LeetCode 1013 - Partition Array Into Three Parts With Equal Sum
 *
 * Brute-force
 */
public class _1013 {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = IntStream.of(A).sum();
        if (sum % 3 != 0) {
            return false;
        }
        int cnt = 0;
        for (int i = 0; i < A.length - 2; i++) {
            cnt += A[i];
            if (cnt == sum / 3) {
                int cnt1 = 0;
                for (int j = i + 1; j < A.length - 1; j++) {
                    cnt1 += A[j];
                    if (cnt1 == sum / 3) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}

