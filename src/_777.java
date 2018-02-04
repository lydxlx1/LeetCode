/**
 * LeetCode 777 - Swap Adjacent in LR String
 * <p>
 * "XL" -> "LX" means we can push L to the left
 * "RX" -> "XR" means we can push R to the right
 */
public class _777 {

    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }

        char[] a = start.toCharArray();
        char[] b = end.toCharArray();

        // Try to move R to the right
        for (int i = a.length - 1, j = b.length - 1; i >= 0 && j >= 0; j--) {
            if (b[j] == 'R') {
                i = Math.min(i, j);
                while (i >= 0 && a[i] == 'X') {
                    i--;
                }
                if (i >= 0 && a[i] == 'R') {
                    a[i] = 'X';
                    a[j] = 'R';
                    i--;
                } else {
                    break;
                }
            }
        }

        // Then try to move L to the left
        for (int i = 0, j = 0; i < a.length && j < b.length; j++) {
            if (b[j] == 'L') {
                i = Math.max(i, j);
                while (i < a.length && a[i] == 'X') {
                    i++;
                }
                if (i < a.length && a[i] == 'L') {
                    a[i] = 'X';
                    a[j] = 'L';
                    i++;
                } else {
                    break;
                }
            }
        }
        return String.valueOf(a).equals(String.valueOf(b));
    }
}

