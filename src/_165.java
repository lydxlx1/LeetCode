/**
 * LeetCode 165 - Compare Version Numbers
 *
 * Note that if the version is not specified, it is 0 by default, i.e.,
 * 1 == 1.0.0
 */
public class _165 {
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        for (int i = 0; i < a.length || i < b.length; i++) {
            int first = i < a.length ? Integer.parseInt(a[i]) : 0;
            int second = i < b.length ? Integer.parseInt(b[i]) : 0;
            if (first != second) return Integer.compare(first, second);
        }
        return 0;
    }
}