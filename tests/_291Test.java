import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _291Test {

    @Test
    public void test() throws Exception {
        _291 sol = new _291();
        boolean actual = sol.wordPatternMatch("abab", "redblueredblue");
        assertTrue(actual);

        actual = sol.wordPatternMatch("aaaa", "asdasdasdasd");
        assertTrue(actual);

        actual = sol.wordPatternMatch("aabb", "xyzabcxzyabc");
        assertFalse(actual);
    }
}