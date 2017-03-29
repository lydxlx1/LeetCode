public class _544_1 {
    private ListNode[] intToList(int n) {
        ListNode head = null, tail = null;
        if (n == 0) head = tail = new ListNode('0');
        else {
            while (n > 0) {
                ListNode p = new ListNode(n % 10 + '0');
                p.next = head;
                head = p;
                n /= 10;

                if (tail == null) tail = head;
            }
        }
        return new ListNode[]{head, tail};
    }

    public String findContestMatch(int n) {

        ListNode[] heads = new ListNode[n];
        ListNode[] tails = new ListNode[n];
        for (int i = 0; i < n; i++) {
            ListNode[] list = intToList(i + 1);
            heads[i] = list[0];
            tails[i] = list[1];
        }

        for (; n > 1; n /= 2)
            for (int i = 0; i < n / 2; i++) {
                ListNode leftParen = new ListNode('(');
                ListNode comma = new ListNode(',');
                ListNode rightParen = new ListNode(')');

                leftParen.next = heads[i];
                tails[i].next = comma;
                comma.next = heads[n - 1 - i];
                tails[n - 1 - i].next = rightParen;

                heads[i] = leftParen;
                tails[i] = rightParen;
            }

        StringBuilder builder = new StringBuilder();
        for (ListNode p = heads[0]; p != null; p = p.next)
            builder.append((char) p.val);
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _544_1().findContestMatch(8));
    }
}
