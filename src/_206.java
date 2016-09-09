/**
 * LeetCode 206 - Reverse Linked List
 */
public class _206 {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode i = head;
            head = head.next;
            i.next = dummy.next;
            dummy.next = i;
        }
        return dummy.next;
    }
}