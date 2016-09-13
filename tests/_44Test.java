import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _44Test {
    @Test
    public void test() throws Exception {
        _44 sol = new _44();
        assertEquals(false, sol.isMatch("aa", "a"));
        assertEquals(true, sol.isMatch("aa", "aa"));
        assertEquals(false, sol.isMatch("aaa", "aa"));
        assertEquals(true, sol.isMatch("aaa", "*"));
        assertEquals(true, sol.isMatch("aaa", "a*"));
        assertEquals(true, sol.isMatch("ab", "??"));
        assertEquals(true, sol.isMatch("ab", "?*"));
        assertEquals(false, sol.isMatch("aab", "c*a*b"));
    }
}

