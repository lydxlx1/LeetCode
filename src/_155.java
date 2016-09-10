import java.util.Stack;

/**
 * LeetCode 155 - Min Stack
 *
 * Use slightly more memory for shorter code.
 */
public class _155 {

    Stack<Integer> stack;
    Stack<Integer> min;

    public _155() {
        stack = new Stack<>();
        min = new Stack<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        min.push(Math.min(min.peek(), x));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}