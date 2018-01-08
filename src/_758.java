/**
 * LeetCode 758 - Bold Words in String
 * <p>
 * Greedy
 */
public class _758 {

    public String boldWords(String[] words, String S) {
        boolean[] shouldCover = new boolean[S.length()];
        for (String word : words) {
            for (int i = 0; i + word.length() <= S.length(); i++) {
                if (S.substring(i, i + word.length()).equals(word)) {
                    for (int j = i; j < i + word.length(); j++) {
                        shouldCover[j] = true;
                    }
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < shouldCover.length; ) {
            if (shouldCover[i]) {
                builder.append("<b>");
                int j = i;
                for (; j < shouldCover.length && shouldCover[j]; j++) {
                    builder.append(S.charAt(j));
                }
                builder.append("</b>");
                i = j;
            } else {
                builder.append(S.charAt(i));
                i++;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        _758 sol = new _758();
        System.out.println(sol.boldWords(new String[]{"ab", "bc"}, "aabcd"));
    }
}



