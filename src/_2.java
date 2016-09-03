import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 2 - Add Two Numbers
 *
 * Not in-place, but short code
 */
public class _2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), p = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            ListNode q = new ListNode(carry);
            if (l1 != null) {
                q.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                q.val += l2.val;
                l2 = l2.next;
            }
            carry = q.val / 10;
            q.val %= 10;

            p.next = q;
            p = q;
        }
        return head.next;
    }
}
