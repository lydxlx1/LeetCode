/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

/**
 * LeetCode 157 - Read N Characters Given Read4
 */
public class _157 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        int actualSize = 0, smallBufferSize = 0;
        char[] smallBuffer = new char[4];
        smallBufferSize = read4(smallBuffer);
        while (smallBufferSize > 0 && n > 0) {
            for (int i = 0; i < smallBufferSize && i < n; i++)
                buf[actualSize++] = smallBuffer[i];
            n -= Math.min(n, smallBufferSize);
            smallBufferSize = read4(smallBuffer);
        }
        return actualSize;
    }
}