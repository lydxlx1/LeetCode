/**
 * LeetCode 920 - Number of Music Playlists
 * <p>
 * A very tricky/strange DP
 */
public class _920 {

    long mod = 1000000007;
    int K, N;
    Long[][] f;

    public int numMusicPlaylists(int N, int L, int K) {
        f = new Long[L + 1][N + 1];
        this.K = K;
        this.N = N;
        return (int) f(L, N);
    }

    long f(int listLength, int numOfUniqueSongs) {
        if (listLength == 0) {
            return numOfUniqueSongs == 0 ? 1 : 0;
        }
        if (numOfUniqueSongs == 0) {
            return 0;
        }
        if (f[listLength][numOfUniqueSongs] != null) {
            return f[listLength][numOfUniqueSongs];
        }

        long res = 0;
        res += f(listLength - 1, numOfUniqueSongs - 1) * (N - (numOfUniqueSongs - 1));
        res %= mod;
        res += f(listLength - 1, numOfUniqueSongs) * Math.max(0, numOfUniqueSongs - K);
        res %= mod;

        f[listLength][numOfUniqueSongs] = res;
        return res;
    }
}

