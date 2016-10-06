/**
 * LeetCode 158 - Read N Characters Given Read4 II - Call multiple times
 * <p>
 * No thing too special. Just read the problem statement carefully.
 */
public class _158 extends Reader4 {

    private char[] smallBuf = new char[4];
    private int smallBufPtr = 0, smallBufSize = 0;

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        int len = 0;
        while (len < n && hasNext()) buf[len++] = next();
        return len;
    }

    private boolean hasNext() {
        if (smallBufPtr < smallBufSize) return true;
        smallBufPtr = 0;
        return (smallBufSize = read4(smallBuf)) > 0;
    }

    private char next() {
        return smallBuf[smallBufPtr++];
    }
}
