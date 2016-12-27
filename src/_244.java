import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 244 - Shortest Word Distance II
 */
public class _244 {
    Map<String, List<Integer>> map = new HashMap<>();

    public _244(String[] words) {
        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        assert (map.containsKey(word1));
        assert (map.containsKey(word2));
        int dist = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        for (int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            dist = Math.min(dist, Math.abs(list1.get(i) - list2.get(j)));
            if (list1.get(i) < list2.get(j)) i++;
            else j++;
        }
        return dist;
    }

    public static void main(String[] args) {
        _244 a = new _244(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        System.out.println(a.shortest("coding", "practice"));
        System.out.println(a.shortest("makes", "coding"));
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");