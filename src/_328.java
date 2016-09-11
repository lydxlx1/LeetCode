/**
 * ListCode 328 - Odd Even Linked List
 *
 * O(n) in-place solution
 */
public class _328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head, even = odd == null ? null : odd.next, oddTail = odd;
        for (ListNode i = odd, j = even; i != null && j != null; )
            if (i.next == j) {
                i.next = j.next;
                i = j.next;
                if (i != null) oddTail = i;
            } else {
                j.next = i.next;
                j = i.next;
            }
        if (oddTail != null) oddTail.next = even;
        return odd;
    }
}
