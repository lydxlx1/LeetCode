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
        squeeze();
    }

    private void squeeze() {
        while (!s.isEmpty() && !s.peekFirst().isInteger()) {
            Deque<NestedInteger> list = new ArrayDeque<>(s.pollFirst().getList());
            while (!list.isEmpty()) s.addFirst(list.pollLast());
        }
    }

    @Override
    public Integer next() {
        return s.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        squeeze();
        return s.isEmpty();
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}