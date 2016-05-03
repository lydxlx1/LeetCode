import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * LeetCode 347 - Top K Frequent Elements
 *
 * Map + Quick Selection
 */
public class _347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        List<Entry<Integer, Integer>> elems = new ArrayList(map.entrySet());
        int l = 0, r = elems.size() - 1, p = 0;
        while (l <= r) {
            p = l - 1;
            for (int i = l; i <= r; i++)
                if (elems.get(i).getValue() >= elems.get(r).getValue()) {
                    Entry<Integer, Integer> tmp = elems.get(++p);
                    elems.set(p, elems.get(i));
                    elems.set(i, tmp);
                }
            if (p - l + 1 == k) break;
            else if (p - l >= k) r = p - 1;
            else {
                k -= p - l + 1;
                l = p + 1;
            }
        }
        return elems.subList(0, p + 1).stream().map(u -> u.getKey()).collect(Collectors.toList());
    }
}