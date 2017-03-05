import java.util.*;

/**
 * LeetCode 514 - Freedom Trail
 * <p>
 * An O(RK)-time solution
 */
public class _514_1 {

    public int findRotateSteps(String ring, String key) {
        int R = ring.length(), K = key.length();
        int[][] prev = new int[R][26], next = new int[R][26];
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            char ch = ring.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }
        for (char ch : map.keySet()) {
            List<Integer> list = map.get(ch);
            for (int i = 0, ptr = 0; i < ring.length(); i++) {
                next[i][ch - 'a'] = list.get(ptr);
                prev[i][ch - 'a'] = list.get((ptr - 1 + list.size()) % list.size());
                if (ring.charAt(i) == ch) ptr = (ptr + 1) % list.size();
            }
        }

        int[][] f = new int[K][R];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < R; j++) {
                f[i][j] = Integer.MAX_VALUE / 2;

                if (key.charAt(i) == ring.charAt(j)) {
                    if (i == 0) f[i][j] = Math.min(f[i][j], dist(0, j, ring.length()));
                    else {
                        int preKey = key.charAt(i - 1) - 'a';
                        f[i][j] = Math.min(f[i][j], f[i - 1][prev[j][preKey]] + dist(prev[j][preKey], j, ring.length()));
                        f[i][j] = Math.min(f[i][j], f[i - 1][next[j][preKey]] + dist(next[j][preKey], j, ring.length()));
                    }
                }
                if (i == key.length() - 1) ans = Math.min(ans, f[i][j]);
            }
        }
        return ans + key.length();
    }

    private int dist(int i, int j, int n) {
        return Math.min(Math.abs(i - j), n - Math.abs(i - j));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new _514_1().findRotateSteps("abc", "aaccbb"));
    }
}
