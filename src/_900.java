/**
 * LeetCode 900 - RLE Iterator
 */
class _900 {

    int ptr = 0;
    int[] A;

    public _900(int[] A) {
        this.A = A;
    }

    public int next(int n) {
        int lastSeen = -1;
        while (ptr < A.length) {
            int min = Math.min(A[ptr], n);
            A[ptr] -= min;
            n -= min;
            lastSeen = A[ptr + 1];
            if (n > 0) {
                ptr += 2;
            } else {
                break;
            }
        }
        return n > 0 ? -1 : lastSeen;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */