import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode 432 - All O`One Data Structure
 * <p>
 * Using a HashMap and a Doubly Circular Linked List to achieve O(1) runtime per operation.
 */
public class _432 {

    private static class Node {
        int cnt;
        Set<String> set = new HashSet<>();
        Node pre, next;

        Node(int cnt) {
            this.cnt = cnt;
            this.pre = this.next = this;
        }
    }

    Map<String, Node> map = new HashMap<>();
    private Node header = new Node(0);

    /**
     * Initialize your data structure here.
     */
    public _432() {

    }

    private void insertAfter(Node nodeBefore, Node nodeToAdd) {
        nodeToAdd.pre = nodeBefore;
        nodeToAdd.next = nodeBefore.next;
        nodeToAdd.pre.next = nodeToAdd.next.pre = nodeToAdd;
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        Node before = map.getOrDefault(key, header);
        int afterCnt = before.cnt + 1;
        Node after = before.next.cnt == afterCnt ? before.next : new Node(afterCnt);

        before.set.remove(key);
        after.set.add(key);

        if (after.pre != before) insertAfter(before, after);
        if (before != header && before.set.size() == 0) remove(before);
        map.put(key, after);
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (!map.containsKey(key)) return;
        Node before = map.get(key); // This "before" node is actually the one on the right
        int cntAfterDec = before.cnt - 1;
        Node after = before.pre.cnt == cntAfterDec ? before.pre : new Node(cntAfterDec); // This "after" node is actually the one on the left

        before.set.remove(key);

        if (cntAfterDec == 0) {
            map.remove(key);
        } else {
            after.set.add(key);
            if (after != before.pre) insertAfter(before.pre, after);
            map.put(key, after);
        }
        if (before.set.size() == 0) remove(before);
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return header.pre == header ? "" : header.pre.set.iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return header.next == header ? "" : header.next.set.iterator().next();
    }
}

