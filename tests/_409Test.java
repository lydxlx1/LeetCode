import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _409Test {

    @Test
    public void test() throws Exception {
        _409 sol = new _409();
        assertEquals(7, sol.longestPalindrome("abccccdd"));
        assertEquals(1, sol.longestPalindrome("abc"));

    }
}


