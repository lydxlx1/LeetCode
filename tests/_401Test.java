import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class _401Test {

    @Test
    public void test() throws Exception {
        _401 sol = new _401();
        List<String> actual = sol.readBinaryWatch(1);
        List<String> expected = Arrays.asList("1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32");
        Collections.sort(actual);
        Collections.sort(expected);
        assertEquals(expected, actual);
    }
}

