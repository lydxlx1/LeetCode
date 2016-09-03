/**
 * LeetCode 2 - Add Two Numbers
 *
 * In-place
 * Beat 31.63%
 */
public class _2_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), p = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            ListNode q = l1 != null ? l1 : l2;
            if (l1 != null && l1 != q) q.val += l1.val;
            if (l2 != null && l2 != q) q.val += l2.val;
            q.val += carry;
            carry = q.val / 10;
            q.val %= 10;

            p.next = q;
            p = p.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) p.next = new ListNode(carry);
        return head.next;
    }
}
