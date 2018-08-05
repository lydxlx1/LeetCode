import java.util.TreeMap;

/**
 * LeetCode 885 - Boats to Save People
 * <p>
 * Greedy
 */
public class _885 {

    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : people) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        while (!map.isEmpty()) {
            ans++;
            int maxKey = map.lastKey();
            map.put(maxKey, map.get(maxKey) - 1);
            if (map.get(maxKey) == 0) {
                map.remove(maxKey);
            }

            Integer secondPeople = map.floorKey(limit - maxKey);
            if (secondPeople != null) {
                map.put(secondPeople, map.get(secondPeople) - 1);
                if (map.get(secondPeople) == 0) {
                    map.remove(secondPeople);
                }
            }
        }
        return ans;
    }
}

