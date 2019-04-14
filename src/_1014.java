/**
 * LeetCode 1014 - Smallest Integer Divisible by K
 *
 * Math
 */
public class _1014 {

    public int smallestRepunitDivByK(int K) {
        int cnt = 1, g = 1 % K;
        boolean[] visited = new boolean[K];
        while (g != 0) {
            cnt++;
            visited[g] = true;
            g = (g * 10 + 1) % K;
            if (visited[g]) {
                return -1;
            }
        }
        return cnt;
    }
}

