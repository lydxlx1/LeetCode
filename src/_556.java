/**
 * LeetCode 556 - Next Greater Element III
 * <p>
 * 1) Next permutation
 * 2) Pay attention to the case when tie appears
 * 3) Pay attention to the case where the permuted number is bigger than MAX_INT
 */
public class _556 {
    private void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void reverse(char[] a, int l, int r) {
        for (; l < r; l++, r--) swap(a, l, r);
    }

    public boolean nextPermutation(char[] a) {
        for (int i = a.length - 2; i >= 0; i--)
            if (a[i] < a[i + 1]) {
                for (int j = a.length - 1; j > i; j--) {
                    if (a[j] > a[i]) {
                        swap(a, i, j);
                        reverse(a, i + 1, a.length - 1);
                        return true;
                    }
                }
                throw new RuntimeException("Should never be here.");
            }
        return false;
    }

    public int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();
        if (!nextPermutation(a)) return -1;
        long tmp = 0;
        for (char ch : a)
            tmp = tmp * 10 + ch - '0';
        return tmp <= Integer.MAX_VALUE ? (int) tmp : -1;
    }

    public static void main(String[] args) {
        _556 sol = new _556();
    }
}
