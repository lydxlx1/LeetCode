import java.util.Arrays;


/**
 * Duplicate Zeros
 *
 * In-place solution
 * Need to pay attention to whether we want to duplicate the last zero.
 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                cnt++;
            }
            if (cnt + (i + 1) >= arr.length) {
                int j = arr.length - 1;
                while (i >= 0) {
                    arr[j--] = arr[i];
                    if (arr[i] == 0 && cnt + (i + 1) <= arr.length) {
                        arr[j--] = arr[i];
                    }
                    i--;
                }
                break;
            }
        }
    }
}
