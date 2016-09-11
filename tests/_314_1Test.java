import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yuan on 9/10/2016.
 */
public class _314_1Test {
    @Test
    public void test() {
        _314_1 sol = new _314_1();
        List<?> actual = sol.verticalOrder(Deserializer.deserializeTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7}));
        List<?> expected = Arrays.asList(Arrays.asList(9), Arrays.asList(3, 15), Arrays.asList(20), Arrays.asList(7));
        assertEquals(expected, actual);

        actual = sol.verticalOrder(Deserializer.deserializeTreeNode(new Integer[]{3, 9, 8, 4, 0, 1, 7}));
        expected = Arrays.asList(Arrays.asList(4), Arrays.asList(9), Arrays.asList(3, 0, 1), Arrays.asList(8), Arrays.asList(7));
        assertEquals(expected, actual);

        actual = sol.verticalOrder(Deserializer.deserializeTreeNode(new Integer[]{3, 9, 8, 4, 0, 1, 7, null, null, null, 2, 5}));
        expected = Arrays.asList(Arrays.asList(4), Arrays.asList(9, 5), Arrays.asList(3, 0, 1), Arrays.asList(8, 2), Arrays.asList(7));
        assertEquals(expected, actual);

        actual = sol.verticalOrder(null);
        expected = Arrays.asList();
        assertEquals(expected, actual);
    }
}