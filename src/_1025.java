/**
 * LeetCode - Divisor Game
 *
 * Game Theory
 */
public class _1025 {

    public boolean divisorGame(int N) {
        boolean[] f = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            f[i] = false;
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[N];
    }
}
