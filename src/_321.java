import java.util.Stack;

/**
 * LeetCode 321 - Create Maximum Number
 *
 * Stack + Greedy
 */
public class _321 {

    String concat(String a, String b) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0, j = 0; i < a.length() || j < b.length(); )
            if (a.substring(i).compareTo(b.substring(j)) > 0) builder.append(a.charAt(i++));
            else builder.append(b.charAt(j++));
        return builder.toString();
    }

    String oneArray(int[] a, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && a[i] > stack.peek() && stack.size() - 1 + a.length - i >= k) stack.pop();
            stack.push(a[i]);
        }
        for (int i = 0; i < k; i++) builder.append(stack.get(i));
        return builder.toString();
    }

    public int[] maxNumber(int[] a, int[] b, int k) {
        String ans = "";
        for (int i = 0; i <= k && i <= a.length; i++)
            if (k - i <= b.length) {
                String tmp = concat(oneArray(a, i), oneArray(b, k - i));
                if (tmp.compareTo(ans) > 0) ans = tmp;
            }
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) arr[i] = ans.charAt(i) - '0';
        return arr;
    }
}