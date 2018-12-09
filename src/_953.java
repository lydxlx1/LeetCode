import java.util.stream.Collectors;

/**
 * LeetCode 953 - Verifying an Alien Dictionary
 */
public class _953 {

    int[] val;

    public boolean isAlienSorted(String[] words, String order) {
        char[] mapping = new char[128];
        for (int i = 0; i < order.length(); i++) {
            mapping[order.charAt(i)] = (char) (i + 'a');
        }
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i].chars().mapToObj(ch -> "" + mapping[ch]).collect(Collectors.joining());
            String second = words[i + 1].chars().mapToObj(ch -> "" + mapping[ch]).collect(Collectors.joining());
            if (first.compareTo(second) > 0) {
                return false;
            }
        }
        return true;
    }
}
