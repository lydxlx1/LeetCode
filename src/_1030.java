import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * LeetCode 1030 - Next Greater Node In Linked List
 *
 * Greedy + TreeMap
 * Note that the "smallest possible j" part can be solved by a linear scan from left to right
 */
public class _1030 {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> a = new ArrayList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (; head != null; head = head.next) {
            a.add(head.val);
        }
        int[] res = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            int val = a.get(i);
            while (!map.isEmpty() && map.firstKey() < val) {
                int key = map.firstKey();
                for (int idx : map.get(key)) {
                    res[idx] = val;
                }
                map.remove(key);
            }
            map.computeIfAbsent(val, k -> new ArrayList<>()).add(i);
        }
        return res;
    }
}

