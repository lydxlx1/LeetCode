import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _402Test {

    @Test
    public void test() throws Exception {
        _402 sol = new _402();
        assertEquals("1219", sol.removeKdigits("1432219", 3));
        assertEquals("12219", sol.removeKdigits("1432219", 2));
        assertEquals("132219", sol.removeKdigits("1432219", 1));
        assertEquals("1432219", sol.removeKdigits("1432219", 0));

        assertEquals("200", sol.removeKdigits("10200", 1));

        assertEquals("0", sol.removeKdigits("10", 2));

        assertEquals("0", sol.removeKdigits("20000", 2));
        assertEquals("0", sol.removeKdigits("20000", 5));
    }
}

