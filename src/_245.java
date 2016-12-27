/**
 * LeetCode 245 - Shortest Word Distance III
 * <p>
 * Linear Scan
 */
public class _245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        boolean equal = word1.equals(word2);
        for (int i = 0, ptr1 = -1, ptr2 = -1; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (equal) ptr2 = ptr1;
                ptr1 = i;
            } else if (words[i].equals(word2)) {
                ptr2 = i;
            } else {
                continue;
            }
            if (ptr1 != -1 && ptr2 != -1) {
                distance = Math.min(distance, Math.abs(ptr1 - ptr2));
            }
        }
        return distance;
    }
}