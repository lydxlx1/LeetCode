/**
 * LeetCode 974 - Subarray Sums Divisible by K
 *
 * Prefix Sum
 */
public class _974 {

    public int subarraysDivByK(int[] A, int K) {
        int prefixSum = 0, ans = 0;
        int[] cnt = new int[K];

        cnt[0] = 1;
        for (int i = 0; i < A.length; i++) {
            prefixSum += K + A[i] % K;
            prefixSum %= K;

            ans += cnt[prefixSum];
            cnt[prefixSum]++;
        }
        return ans;
    }
}
