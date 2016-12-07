import java.util.*;

/**
 * LeetCode 341 - Flatten Nested List Iterator
 * <p>
 * This is a lazier implementation.
 */
public class _341_1 implements Iterator<Integer> {

    static class NestedIntegerAndIndex {
        NestedInteger nestedInteger;
        int nextIndex;

        public NestedIntegerAndIndex(NestedInteger nestedInteger, int nextIndex) {
            this.nestedInteger = nestedInteger;
            this.nextIndex = nextIndex;
        }
    }

    private final Stack<NestedIntegerAndIndex> stack;

    public _341_1(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(new NestedIntegerAndIndex(new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                throw new IllegalStateException("Not an integer.");
            }

            @Override
            public List<NestedInteger> getList() {
                return nestedList;
            }
        }, 0));
    }

    @Override
    public Integer next() {
        return stack.pop().nestedInteger.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty() && !stack.peek().nestedInteger.isInteger()) {
            NestedIntegerAndIndex top = stack.peek();
            if (top.nextIndex >= top.nestedInteger.getList().size()) stack.pop();
            else stack.push(new NestedIntegerAndIndex(top.nestedInteger.getList().get(top.nextIndex++), 0));
        }
        return !stack.isEmpty();
    }
}