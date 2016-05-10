import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode 347 - Top K Frequent Elements
 * <p>
 * Map + Counting Sort
 */
public class _347_1 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer>[] cnt = new List[nums.length + 1];
        for (int i = 0; i < cnt.length; i++)
            cnt[i] = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            cnt[entry.getValue()].add(entry.getKey());
        return IntStream.range(0, nums.length + 1)
                .map(i -> nums.length - i)
                .mapToObj(i -> cnt[i])
                .flatMap(o -> o.stream())
                .limit(k).collect(Collectors.toList());
    }
}