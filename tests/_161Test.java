import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _161Test {
    @Test
    public void test() throws Exception {
        _161 sol = new _161();

        String s = "";
        String t = "";
        boolean actual = sol.isOneEditDistance(s, t);
        assertEquals(false, actual);

        s = "";
        t = "a";
        actual = sol.isOneEditDistance(s, t);
        assertEquals(true, actual);

        s = "a";
        t = "";
        actual = sol.isOneEditDistance(s, t);
        assertEquals(true, actual);

        s = "aa";
        t = "";
        actual = sol.isOneEditDistance(s, t);
        assertEquals(false, actual);


        s = "acb";
        t = "acd";
        actual = sol.isOneEditDistance(s, t);
        assertEquals(true, actual);


        s = "aaa";
        t = "aaa";
        actual = sol.isOneEditDistance(s, t);
        assertEquals(false, actual);

        s = "abc";
        t = "aee";
        actual = sol.isOneEditDistance(s, t);
        assertEquals(false, actual);
    }

}