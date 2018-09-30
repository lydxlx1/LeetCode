import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode X of a Kind in a Deck of Cards
 *
 * Math
 */
public class _914 {

    int gcd(int i, int j) {
        return j == 0 ? i : gcd(j, i % j);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int g = map.values().iterator().next();
        for (int i : map.values()) {
            g = gcd(g, i);
        }
        return g >= 2;
    }
}

