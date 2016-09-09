import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class _165Test {

    @Test
    public void compareVersion() {
        _165 sol = new _165();
        int actual = sol.compareVersion("1.0", "1.0");
        assertEquals(0, actual);

        actual = sol.compareVersion("1.0", "1");
        assertEquals(0, actual);

        actual = sol.compareVersion("1", "1.0");
        assertEquals(0, actual);

        actual = sol.compareVersion("1.0.0.0.0.1", "1.0");
        assertEquals(1, actual);

        actual = sol.compareVersion("1.0", "1.0.0.0.0.1");
        assertEquals(-1, actual);

        actual = sol.compareVersion("0.1", "1.1");
        assertEquals(-1, actual);

        actual = sol.compareVersion("1.1", "1.2");
        assertEquals(-1, actual);

        actual = sol.compareVersion("1.2", "13.7");
        assertEquals(-1, actual);

        actual = sol.compareVersion("1.12", "1.2");
        assertEquals(1, actual);
    }
}