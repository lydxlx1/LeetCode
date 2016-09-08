import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 146 - LRU Cache
 *
 * Doubly Connected Linked List + Hash Table
 */
public class _146 {

    static class Node {
        int key, val;
        Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            pre = next = this;
        }
    }

    Node head;
    Map<Integer, Node> map;
    int capacity;

    public _146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node(0, 0);
    }

    private Node delete(Node node) {
        map.remove(node.key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node;
    }

    private Node insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.pre = head;
        node.pre.next = node;
        node.next.pre = node;
        return node;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) return insert(delete(node)).val;
        else return -1;
    }

    public void set(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            insert(delete(node));
        } else {
            if (map.size() >= capacity) delete(head.pre);
            insert(new Node(key, value));
        }
    }
}