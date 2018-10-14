/**
 * LeetCode 922 - Sort Array by Parity II
 */
public class _922 {

    public int[] sortArrayByParityII(int[] A) {
        int[] res = A.clone();
        for (int i = 0, even = 0, odd = 1; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                res[even] = A[i];
                even += 2;
            } else {
                res[odd] = A[i];
                odd += 2;
            }
        }
        return res;
    }
}
