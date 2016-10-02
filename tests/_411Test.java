import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class _411Test {

    @Test
    public void test() throws Exception {
        _411 sol = new _411();
        List<?> expected = Arrays.asList("a4");
        assertTrue(expected.contains(sol.minAbbreviation("apple", new String[]{"blade"})));

        expected = Arrays.asList("1p3", "ap3", "a3e", "2p2", "3le", "3l1");
        assertTrue(expected.contains(sol.minAbbreviation("apple", new String[]{"plain", "amber", "blade"})));
    }
}


