import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Dinner Plate Stacks
 *
 * Data Structure
 */
public class DinnerPlateStacks {

    int capacity;
    TreeSet<Integer> occupiedIndices = new TreeSet<>();
    TreeSet<Integer> nonFullIndices = new TreeSet<>();
    List<Stack<Integer>> stacks = new ArrayList<>();

    public DinnerPlateStacks(int capacity) {
        this.capacity = capacity;
    }

    public void push(int val) {
        int index;
        if (nonFullIndices.isEmpty()) {
            index = stacks.size();
            stacks.add(new Stack<>());
        } else {
            index = nonFullIndices.first();
        }
        occupiedIndices.add(index);
        stacks.get(index).push(val);
        if (stacks.get(index).size() >= capacity) {
            nonFullIndices.remove(index);
        } else {
            nonFullIndices.add(index);
        }
    }

    public int pop() {
        if (occupiedIndices.isEmpty()) {
            return -1;
        }
        return popAtStack(occupiedIndices.last());
    }

    public int popAtStack(int index) {
        if (index >= stacks.size() || stacks.get(index).isEmpty()) {
            return -1;
        }
        int val = stacks.get(index).pop();
        nonFullIndices.add(index);
        if (stacks.get(index).isEmpty()) {
            occupiedIndices.remove(index);
        }
        return val;
    }
}
