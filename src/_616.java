/**
 * LeetCode 616 - Add Bold Tag in String
 * <p>
 * O(1000^2)-time solution without using KMP
 */
public class _616 {
    public String addBoldTag(String s, String[] dict) {
        boolean[] covered = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String each : dict)
                if (s.startsWith(each, i))
                    covered[i + each.length() - 1] = true;
            for (int j = s.length() - 1; j > i; j--)
                if (covered[j])
                    covered[j - 1] = true;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0, j = 0; i < covered.length; )
            if (covered[i]) {
                builder.append("<b>");
                for (j = i; j < covered.length && covered[j]; j++)
                    builder.append(s.charAt(j));
                i = j;
                builder.append("</b>");
            } else {
                builder.append(s.charAt(i++));
            }
        return builder.toString();
    }
}
