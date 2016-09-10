import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 155 - Min Stack
 *
 * Use as little memory as possible
 */
public class _155_1 {

    List<Integer> stack;
    Stack<Integer> minInd;

    public _155_1() {
        stack = new ArrayList<>();
        minInd = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if (minInd.isEmpty() || x < stack.get(minInd.peek())) minInd.push(stack.size() - 1);
    }

    public void pop() {
        stack.remove(stack.size() - 1); // O(1)
        if (minInd.peek() == stack.size()) minInd.pop();
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return stack.get(minInd.peek());
    }
}