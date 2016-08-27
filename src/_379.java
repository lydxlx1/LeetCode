/**
 * LeetCode 379 - Design Phone Directory
 *
 * This problem is a bit weird. I don't see why the function check() is particular useful.
 *
 */
public class _379 {

    int[] heap;
    boolean[] visited;
    int heapPtr;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public _379(int maxNumbers) {
        heap = new int[maxNumbers];
        visited = new boolean[maxNumbers];
        for (int i = 0; i < maxNumbers; i++) heap[i] = i;
        heapPtr = maxNumbers;
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (heapPtr <= 0) return -1;
        int num = heap[--heapPtr];
        visited[num] = true;
        return num;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return !visited[number];
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        if (visited[number]) {
            visited[number] = false;
            heap[heapPtr++] = number;
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */