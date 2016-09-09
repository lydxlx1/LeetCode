import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 127 - Word Ladder
 *
 * BFS approach
 */
public class _127 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) return 1;
        String[] queueStr = new String[wordList.size() + 1];
        int[] queueDist = new int[wordList.size() + 1];
        queueStr[0] = beginWord;
        queueDist[0] = 1;
        wordList.remove(beginWord);
        int head = 0, tail = 1;
        while (head < tail) {
            char[] chars = queueStr[head].toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char backup = chars[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    chars[i] = j;
                    String str = String.valueOf(chars);
                    if (str.equals(endWord)) return queueDist[head] + 1;
                    if (wordList.contains(str)) {
                        wordList.remove(str);
                        queueStr[tail] = str;
                        queueDist[tail++] = queueDist[head] + 1;
                    }
                }
                chars[i] = backup;
            }
            head++;
        }
        return 0;
    }
}