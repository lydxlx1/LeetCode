import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 386 - Lexicographical Numbers
 *
 * Using a Stack
 */
public class _386 {


    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>(n);
        int[] stack = new int[200];
        int top = 0;
        for (int i = 9; i >= 1; i--)
            if (i <= n) stack[top++] = i;
        while (top > 0) {
            int current = stack[--top];
            ans.add(current);
            for (int i = 9; i >= 0; i--) {
                int next = current * 10 + i;
                if (next <= n) stack[top++] = next;
            }
        }
        return ans;
    }
}