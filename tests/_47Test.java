import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;

public class _47Test {

    @Test
    public void test() throws Exception {
        _47 sol = new _47();
        List<?> actual = sol.permuteUnique(new int[]{1, 1, 2});
        List<?> expected = Arrays.asList(Arrays.asList(1, 1, 2), Arrays.asList(1, 2, 1), Arrays.asList(2, 1, 1));
        assertEquals(expected, actual);

        int[] largeArray = new int[1111];
        Arrays.fill(largeArray, 1);
        actual = sol.permuteUnique(largeArray);
        expected = Arrays.asList(IntStream.of(largeArray).boxed().collect(Collectors.toList()));
        assertEquals(expected, actual);
    }
}