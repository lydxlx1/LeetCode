import java.util.Stack;

/**
 * LeetCode 901 - Online Stock Span
 *
 * Monotone-Stack
 */
public class _901 {

    Stack<int[]> s = new Stack<>();


    public _901() {

    }

    public int next(int price) {
        int res = 0;
        while (!s.isEmpty() && s.peek()[0] <= price) {
            res += s.pop()[1];
        }
        s.push(new int[]{price, res + 1});
        return res + 1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */