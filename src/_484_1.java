import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 * LeetCode 484 - Find Permutation
 * <p>
 * Constructive approach
 */
public class _484_1 {

    static _484_1 sol = new _484_1();

    public int[] findPermutation(String s) {
        int[] arr = new int[s.length() + 1];
        for (int i = 0; i < arr.length; i++) arr[i] = i + 1;
        for (int i = 0; i < s.length(); )
            if (s.charAt(i) == 'I') i++;
            else {
                int j;
                for (j = i + 1; j < s.length() && s.charAt(j) == 'D'; j++) ;
                reverse(arr, i, j);
                i = j;
            }
        return arr;
    }

    private void reverse(int[] a, int l, int r) {
        for (; l < r; l++, r--) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
        }
    }

    @Test
    public void test() {
        List<Integer> expected;
        List<Integer> actual;
        String s;

        s = "II";
        expected = Arrays.asList(1, 2, 3);
        actual = IntStream.of(sol.findPermutation(s)).boxed().collect(toList());
        assertEquals(expected, actual);

        s = "DD";
        expected = Arrays.asList(3, 2, 1);
        actual = IntStream.of(sol.findPermutation(s)).boxed().collect(toList());
        assertEquals(expected, actual);

        s = "DDDI";
        expected = Arrays.asList(4, 3, 2, 1, 5);
        actual = IntStream.of(sol.findPermutation(s)).boxed().collect(toList());
        assertEquals(expected, actual);

        s = "";
        expected = Arrays.asList(1);
        actual = IntStream.of(sol.findPermutation(s)).boxed().collect(toList());
        assertEquals(expected, actual);
    }
}
