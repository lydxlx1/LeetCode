import java.util.TreeMap;

/**
 * LeetCode 954 - Array of Doubled Pairs
 *
 * Greedy
 */
public class _954 {

    public boolean canReorderDoubled(int[] A) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i : A) {
            tree.put(i, tree.getOrDefault(i, 0) + 1);
        }

        while (!tree.isEmpty()) {
            // Pick the one with the largest abs value.
            int max = Math.abs(tree.firstKey()) > Math.abs(tree.lastKey()) ? tree.firstKey() : tree.lastKey();
            remove(tree, max);
            if (max % 2 != 0 || !tree.containsKey(max / 2)) {
                return false;
            }
            remove(tree, max / 2);
        }
        return true;
    }

    void remove(TreeMap<Integer, Integer> tree, int key) {
        tree.put(key, tree.get(key) - 1);
        if (tree.get(key) == 0) {
            tree.remove(key);
        }
    }
}

