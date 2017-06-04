import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * LeetCode 609 - Find Duplicate File in System
 * <p>
 * A straightforward problem
 */
public class _609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String wholePath : paths) {
            String[] tokens = wholePath.split(" ");
            String dir = tokens[0];
            for (int i = 1; i < tokens.length; i++) {
                int index = tokens[i].indexOf("(");
                String fileName = tokens[i].substring(0, index);
                String content = tokens[i].substring(index);
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(dir + "/" + fileName);
            }
        }
        return map.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList());
    }
}