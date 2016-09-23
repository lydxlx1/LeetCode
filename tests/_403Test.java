import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _403Test {

    @Test
    public void test() throws Exception {
        _403 sol = new _403();
        assertTrue(sol.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        assertFalse(sol.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
        assertFalse(sol.canCross(new int[]{0, 3}));
        assertTrue(sol.canCross(new int[]{0}));
    }
}


