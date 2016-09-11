import java.util.*;

/**
 * LeetCode 341 - Flatten Nested List Iterator
 * <p>
 * Basically use a stack to mimic the dfs order.
 * I am using a Deque instead in my code since it is more convenience.
 */
public class _341 implements Iterator<Integer> {
    Deque<NestedInteger> s;

    public _341(List<NestedInteger> nestedList) {
        s = new ArrayDeque<>(nestedList == null ? Arrays.asList() : nestedList);
    }

    @Override
    public Integer next() {
        return s.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!s.isEmpty() && !s.peekFirst().isInteger()) {
            List<NestedInteger> list = s.pollFirst().getList();
            for (int i = list.size() - 1; i >= 0; i--) s.addFirst(list.get(i));
        }
        return !s.isEmpty();
    }
}
