import java.util.*;

/**
 * LeetCode 381 - Insert Delete GetRandom O(1) - Duplicates allowed
 */
public class _381 {

    Map<Integer, Set<Integer>> indices = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();

    /**
     * Initialize your data structure here.
     */
    public _381() {

    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        indices.putIfAbsent(val, new HashSet<>());
        boolean flag = indices.get(val).isEmpty();

        indices.get(val).add(list.size());
        list.add(val);

        return flag;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        indices.putIfAbsent(val, new HashSet<>());
        boolean flag = !indices.get(val).isEmpty();
        if (flag) {
            int valPos = indices.get(val).iterator().next();
            indices.get(val).remove(valPos);

            if (valPos < list.size() - 1) {
                int lastElem = list.get(list.size() - 1);
                list.set(valPos, list.get(list.size() - 1));
                indices.get(lastElem).add(valPos); // if we put add before remove, we even don't need the outer if-statement
                indices.get(lastElem).remove(list.size() - 1);
            }

            list.remove(list.size() - 1);
        }

        return flag;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */