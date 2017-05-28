import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 599 - Minimum Index Sum of Two Lists
 * <p>
 * Brute-force since n is at most 1000...
 */
public class _599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int minSum = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list1.length; i++)
            for (int j = 0; j < list2.length; j++)
                if (list1[i].equals(list2[j])) {
                    if (i + j < minSum) {
                        minSum = i + j;
                        res.clear();
                    }
                    if (i + j == minSum)
                        res.add(list1[i]);
                }
        return res.toArray(new String[res.size()]);
    }
}
