import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * LeetCode 1073 - Adding Two Negabinary Numbers
 */
public class _1073 {

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        for (int i = arr1.length - 1; i >= 0; i--) {
            a.add(arr1[i]);
        }
        for (int i = arr2.length - 1; i >= 0; i--) {
            b.add(arr2[i]);
        }
        for (int i = 0; i < Math.max(a.size(), b.size()) + 10; i++) {
            c.add(0);
        }

        for (int i = 0; i < c.size() - 2; i++) {
            int val = c.get(i);
            val += i < a.size() ? a.get(i) : 0;
            val += i < b.size() ? b.get(i) : 0;

            c.set(i + 1, c.get(i + 1) - val / 2);
            c.set(i, val % 2);

            // !!!
            if (val == -1) {
                c.set(i, 1);
                c.set(i + 1, c.get(i + 1) + 1);
            }
        }
        // Remove extra leading zeros
        while (c.size() > 1 && c.get(c.size() - 1) == 0) {
            c.remove(c.size() - 1);
        }

        Collections.reverse(c);
        return c.stream().mapToInt(i -> i).toArray();
    }
}
