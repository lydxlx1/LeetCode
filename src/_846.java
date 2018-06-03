import java.util.TreeMap;

/**
 * LeetCode 846 - Hand of Straights
 * <p>
 * Solution via using a TreeMap.
 */
public class _846 {

    public boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if (n % W != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < hand.length / W; i++) {
            int min = map.firstKey();
            for (int j = min; j < min + W; j++) {
                if (!map.containsKey(j)) {
                    return false;
                }
                map.put(j, map.get(j) - 1);
                if (map.get(j) == 0) {
                    map.remove(j);
                }
            }
        }
        return true;
    }
}

