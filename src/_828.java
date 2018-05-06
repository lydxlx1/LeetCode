import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * LeetCode 828 - Unique Letter String
 * <p>
 * Counting
 */
public class _828 {

    public int uniqueLetterString(String S) {
        long ans = 0;
        long mod = 1000000007;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }

        for (List<Integer> indices : map.values()) {
            for (int i = 0; i < indices.size(); i++) {
                long left = i == 0 ? indices.get(i) + 1 : indices.get(i) - indices.get(i - 1);
                long right = i == indices.size() - 1 ? S.length() - indices.get(i) : indices.get(i + 1) - indices.get(i);
                ans += left * right % mod;
                ans %= mod;
            }
        }

        return (int) ans;
    }
}

