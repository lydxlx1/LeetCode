import java.util.*;

/**
 * LeetCode 170 - Two Sum III - Data structure design
 * <p>
 * Pay attention to the following nasty cases:
 * [0, 0] find 0
 * [0] find 0
 */
public class _170 {

    Map<Integer, Integer> cnt = new HashMap<>();
    Set<Integer> set = new HashSet<>();


    // Add the number to an internal data structure.
    public void add(int number) {
        cnt.putIfAbsent(number, 0);
        cnt.put(number, cnt.get(number) + 1);
        set.add(number);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        if (value % 2 == 0 && cnt.containsKey(value / 2) && cnt.get(value / 2) >= 2) return true;
        for (int i : set) if (i != value - i && set.contains(value - i)) return true;
        return false;
    }
}


// Your _170 object will be instantiated and called as such:
// _170 twoSum = new _170();
// twoSum.add(number);
// twoSum.find(value);