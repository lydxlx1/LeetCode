import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _408Test {

    @Test
    public void test() throws Exception {
        _408 sol = new _408();
        assertTrue(sol.validWordAbbreviation("internationalization", "i12iz4n"));
        assertFalse(sol.validWordAbbreviation("apple", "a2e"));
        assertFalse(sol.validWordAbbreviation("", "0"));
        assertFalse(sol.validWordAbbreviation("apple", "a0pple"));
        assertFalse(sol.validWordAbbreviation("apple", "a01ple"));
    }
}


