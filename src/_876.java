/**
 * LeetCode 876 - Middle of the Linked List
 * <p>
 * Fast-and-slow pointers
 */
public class _876 {

    public ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast != null ? fast.next : fast;
        }
        return slow;
    }
}

