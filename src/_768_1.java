import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class _768_1 {

    public int maxChunksToSorted(int[] arr) {
        int[] sorted = IntStream.of(arr).sorted().toArray();
        Map<Integer, Integer> counter = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            counter.put(arr[i], counter.getOrDefault(arr[i], 0) + 1);
            if (counter.containsKey(arr[i]) && counter.get(arr[i]) == 0) {
                counter.remove(arr[i]);
            }

            counter.put(sorted[i], counter.getOrDefault(sorted[i], 0) - 1);
            if (counter.containsKey(sorted[i]) && counter.get(sorted[i]) == 0) {
                counter.remove(sorted[i]);
            }

            if (counter.size() == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _768_1 sol = new _768_1();
        System.out.println(sol.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(sol.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
    }
}



