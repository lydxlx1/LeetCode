import java.util.Arrays;

/**
 * LeetCode 1033 - Moving Stones Until Consecutive
 *
 * Min = 1 case is tricky.
 */
public class _1033 {

    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        int max = arr[2] - arr[0] - 2;
        int min = 2;
        if (arr[1] - arr[0] == 1 || arr[2] - arr[1] == 1) {
            min = 1;
        }
        if (arr[1] - arr[0] == 2 || arr[2] - arr[1] == 2) {
            min = Math.min(min, 1);
        }
        if (arr[1] - arr[0] == 1 && arr[2] - arr[1] == 1) {
            min = 0;
        }
        return new int[]{min, max};
    }
}
