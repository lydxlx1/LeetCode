import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 385 - Mini Parser
 * <p>
 * Top-down approach
 */
public class _385 {
    int ptr = 0;

    private NestedInteger parseInt(String s) {
        int sign = 1, num = 0;
        if (s.charAt(ptr) == '-') {
            sign = -1;
            ptr++;
        }
        while (ptr < s.length() && Character.isDigit(s.charAt(ptr))) num = num * 10 + s.charAt(ptr++) - '0';
        return new NestedInteger(sign * num);
    }

    private NestedInteger parseList(String s) {
        NestedInteger list = new NestedInteger();
        ptr++; // skip [
        while (s.charAt(ptr) != ']') {
            list.add(parse(s));
            if (s.charAt(ptr) == ',') ptr++;
        }
        ptr++; // skip ]
        return list;
    }

    private NestedInteger parse(String s) {
        return s.charAt(ptr) == '[' ? parseList(s) : parseInt(s);
    }

    public NestedInteger deserialize(String s) {
        ptr = 0;
        return parse(s);
    }

    
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return true;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 0;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }
}
