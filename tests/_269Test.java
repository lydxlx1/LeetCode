import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _269Test {

    public void check(String[] words, String expected) throws Exception {
        _269 sol = new _269();
        String actual = sol.alienOrder(words);
        assertEquals(expected, actual);
    }

    @Test
    public void test() throws Exception {
        check(new String[]{"wrt", "wrf", "er", "ett", "rftt"}, "wertf");
        check(new String[]{"a", "ab"}, "ab");
        check(new String[]{"a", "b", "a"}, "");
        check(new String[]{"za", "zb", "ca", "cb"}, "abzc");
    }
}