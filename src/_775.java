/**
 * LeetCode 775 - Global and Local Inversions
 * <p>
 * Binary Indexed Tree
 */
public class _775 {

    public boolean isIdealPermutation(int[] A) {
        int local = 0, global = 0;
        int[] bit = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            if (i + 1 < A.length && A[i] > A[i + 1]) {
                local++;
            }
            global += sum(bit, A.length) - sum(bit, A[i] + 1);
            inc(bit, A[i] + 1);
        }
        return local == global;
    }

    void inc(int[] bit, int index) {
        for (; index < bit.length; index += Integer.lowestOneBit(index)) {
            bit[index]++;
        }
    }

    int sum(int[] bit, int index) {
        int sum = 0;
        for (; index > 0; index -= Integer.lowestOneBit(index)) {
            sum += bit[index];
        }
        return sum;
    }
}



