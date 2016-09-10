import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class _155Test {

    @Test
    public void test() throws Exception {
        _155 s = new _155();

        s.push(-2);
        assertEquals(-2, s.getMin());
        assertEquals(-2, s.top());

        s.push(0);
        assertEquals(-2, s.getMin());
        assertEquals(0, s.top());

        s.push(-3);
        assertEquals(-3, s.getMin());
        assertEquals(-3, s.top());

        s.pop();
        assertEquals(-2, s.getMin());
        assertEquals(0, s.top());

        s.pop();
        assertEquals(-2, s.getMin());
        assertEquals(-2, s.top());

        s.pop();
        try {
            s.pop();
        } catch (EmptyStackException e) {
            // do nothing
        }
    }
}