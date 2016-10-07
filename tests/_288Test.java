import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _288Test {
    @Test
    public void test() {
        _288 sol = new _288(new String[]{"dog"});

        assertFalse(sol.isUnique("dig"));
        assertFalse(sol.isUnique("dug"));
        assertFalse(sol.isUnique("dag"));
        assertTrue(sol.isUnique("dog"));
        assertTrue(sol.isUnique("doge"));
    }

}