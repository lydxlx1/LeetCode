/**
 * LeetCode 941 - Valid Mountain Array
 *
 * Two-pointer
 */
public class _941 {

    public boolean validMountainArray(int[] a) {
        if (a == null || a.length < 3) return false;
        int i = 0, j = a.length - 1;
        while (i < j) {
            if (a[i] < a[i + 1]) i++;
            else if (a[j - 1] > a[j]) j--;
            else return false;
        }
        return i > 0 && i < a.length - 1;
    }
}

