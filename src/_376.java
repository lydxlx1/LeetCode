/**
 * LeetCode 376 - Wiggle Subsequence
 *
 * Climb continuously up/down alternatively.
 * Be careful for tie cases (i.e., skip ties and try to push the pointer as far as possible)
 */
public class _376 {
    public int wiggleMaxLength(int[] a) {
        if (a.length == 0) return 0;
        int len = 1, j = 0;
        while (j + 1 < a.length && a[j] == a[j + 1]) j++;
        for (int i = j + 1; i < a.length; ) {
            if (a[i] > a[j]) while (i < a.length && a[i] >= a[i - 1]) i++;
            else if (a[i] < a[j]) while (i < a.length && a[i] <= a[i - 1]) i++;
            else return -1; // should never be here

            j = i - 1;
            len++;
        }
        return len;
    }
}
