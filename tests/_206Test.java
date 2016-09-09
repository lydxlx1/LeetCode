import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class _206Test {

    @Test
    public void test() {
        ListNode ans = (new _206()).reverseList(null);
        assertEquals(null, ans);

        ListNode b = new ListNode(1);
        ans = (new _206()).reverseList(b);
        assertEquals(b, ans);

        ListNode c = new ListNode(2);
        c.next = b;
        ans = (new _206()).reverseList(c);
        assertEquals(b, ans);
        assertEquals(c, ans.next);
        assertEquals(null, ans.next.next);
    }
}