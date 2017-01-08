/**
 * LeetCode 481 - Magical String
 * <p>
 * Use BFS to generate the string
 */
public class _481 {
    public int magicalString(int n) {
        int[] a = new int[n + 5];
        a[0] = 1;
        a[1] = 2;
        a[2] = 2;
        for (int i = 2, j = 2; j < n; i++) {
            int nextValue = 3 - a[j];
            a[++j] = nextValue;
            if (a[i] == 2) a[++j] = nextValue;
        }
        int oneCnt = 0;
        for (int i = 0; i < n; i++)
            if (a[i] == 1) oneCnt++;
        return oneCnt;
    }
}