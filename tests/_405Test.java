import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _405Test {

    @Test
    public void test() throws Exception {
        _405 sol = new _405();
        assertEquals("1a", sol.toHex(26));
        assertEquals("ffffffff", sol.toHex(-1));
        assertEquals("0", sol.toHex(0));
    }
}