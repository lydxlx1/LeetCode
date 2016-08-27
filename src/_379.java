/**
 * LeetCode 379 - Design Phone Directory
 *
 * This problem is a bit weird. I don't see why the function check() is particularly useful.
 * Ideally, one would like to do the following two steps in a row.
 *
 * if (check(number)) get(number);
 *
 * But, the get() function in this problem is not restricted and thus can return any available numbers.
 *
 * The problem will become more interesting if it asks for implementing one more method:
 *
 * bool checkAndGet(int number)
 * @return - Return true if number is available and reserve it on the fly.
 *         - Return false if number is already requested, indicating the failure of this attempt.
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
