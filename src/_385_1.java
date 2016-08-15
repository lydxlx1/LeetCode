import java.util.List;
import java.util.Scanner;

/**
 * LeetCode 385 - Mini Parser
 * <p>
 * Top-down approach using Scanner
 */
public class _385_1 {


    private NestedInteger parse(Scanner cin) {
        if (cin.hasNextInt()) return new NestedInteger(cin.nextInt());
        else {
            NestedInteger list = new NestedInteger();
            cin.next("\\[");
            while (!cin.hasNext("\\]")) {
                list.add(parse(cin));
                if (cin.hasNext(",")) cin.next(",");
            }
            cin.next("\\]");
            return list;
        }
    }

    public NestedInteger deserialize(String s) {
        return parse(new Scanner(s.replaceAll("[,\\[\\]]", " $0 ")));
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
