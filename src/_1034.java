import java.util.Arrays;

public class _1034 {


    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        int max = arr[2] - arr[0] - 2;
        int min = 2;
        if (arr[1] - arr[0] == 1 || arr[2] - arr[1] == 1) {
            min = 1;
            if (arr[1] - arr[0] == 1 && arr[2] - arr[1] == 1) {
                min = 0;
            }
        }
        if (arr[1] - arr[0] == 2 || arr[2] - arr[1] == 2) {
            min = Math.min(min, 1);
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        _1034 sol = new _1034();

        System.out.println(Arrays.toString(sol.numMovesStones(1, 2, 5)));
        System.out.println(Arrays.toString(sol.numMovesStones(4, 3, 2)));
        System.out.println(Arrays.toString(sol.numMovesStones(3, 5, 1)));

    }
}
