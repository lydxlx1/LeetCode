import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _400Test {

    @Test
    public void test() throws Exception {
        _400 sol = new _400();
        StringBuilder actual = new StringBuilder();
        StringBuilder expected = new StringBuilder();
        for (int i = 1; i <= 500; i++) {
            actual.append((char) (sol.findNthDigit(i) + '0'));
            expected.append(i);
        }
        assertEquals(expected.toString().subSequence(0, 500), actual.toString());
    }
}

