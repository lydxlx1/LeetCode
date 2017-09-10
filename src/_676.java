import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LeetCode 676 - Implement Magic Dictionary
 * <p>
 * Brute-force
 */
class _676 {

    Set<String> set;

    /**
     * Initialize your data structure here.
     */
    public _676() {
        // Nope
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        set = Stream.of(dict).collect(Collectors.toSet());
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            for (char replace = 'a'; replace <= 'z'; replace++)
                if (ch != replace) {
                    chars[i] = replace;
                    if (set.contains(String.valueOf(chars))) {
                        return true;
                    }
                }
            chars[i] = ch;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */