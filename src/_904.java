import java.util.HashMap;
import java.util.Map;


/**
 * LeetCode 904 - Fruit Into Baskets
 *
 * Sliding-window
 */
public class _904 {

    public int totalFruit(int[] tree) {
        int res = 0;
        Map<Integer, Integer> baskets = new HashMap<>();

        int j = 0;
        for (int i = 0; i < tree.length; i++) {
            while (j < i && baskets.size() == 2 && !baskets.containsKey(tree[i])) {
                baskets.put(tree[j], baskets.get(tree[j]) - 1);
                if (baskets.get(tree[j]) == 0) {
                    baskets.remove(tree[j]);
                }
                j++;
            }

            baskets.put(tree[i], baskets.getOrDefault(tree[i], 0) + 1);
            int sum = 0;
            for (int fruitCount : baskets.values()) {
                sum += fruitCount;
            }

            res = Math.max(res, sum);
        }
        return res;
    }
}

