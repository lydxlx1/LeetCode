import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * LeetCode 568 - Maximum Vacation Days
 * <p>
 * Simple DP
 * Pay attention to the following:
 * <p>
 * 1) Though flights[i][i] is always 0, it is valid to stay at a same city.
 * 2) The first dimension of days represents city, and the second represents date.
 */
public class _568 {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = days.length, K = days[0].length;
        int[][] f = new int[K + 1][N];
        for (int[] row : f)
            Arrays.fill(row, -Integer.MAX_VALUE / 2);

        f[0][0] = 0;
        for (int i = 1; i <= K; i++)
            for (int v = 0; v < N; v++)
                for (int u = 0; u < N; u++)
                    if (u == v || flights[u][v] == 1)
                        f[i][v] = Math.max(f[i][v], f[i - 1][u] + days[v][i - 1]); // index shifted by 1 for days array
        return IntStream.of(f[K]).max().getAsInt();
    }
}