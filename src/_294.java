import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 294 - Flip Game II
 * <p>
 * Nim & Sprague-Grundy Theorem
 */
public class _294 {

    Map<Integer, Integer> map = new HashMap<>();

    private int sg(int i) {
        if (i == 0) return 0;
        if (map.containsKey(i)) return map.get(i);
        boolean[] visited = new boolean[i + 2];
        for (int j = 0; j <= i - 2; j++) {
            int left = sg(j);
            int right = sg(i - 2 - j);
            visited[left ^ right] = true;
        }
        for (int j = 0; j < visited.length; j++)
            if (!visited[j]) {
                map.put(i, j);
                return j;
            }
        throw new RuntimeException("SG value overflow...");
    }

    public boolean canWin(String s) {
        int xor = 0;
        for (int i = 0, j = 0; i < s.length(); )
            if (s.charAt(i) == '+') {
                for (j = i + 1; j < s.length() && s.charAt(j) == '+'; j++) ;
                xor = xor ^ sg(j - i);
                i = j;
            } else {
                i++;
            }
        return xor > 0;
    }
}