import java.util.*;

/**
 * LeetCode 588 - Design In-Memory File System
 * <p>
 * Generalize a trie
 */
public class _588 {

    class Node {
        boolean isFile = false;
        String name;
        Map<String, Node> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        public Node(String name) {
            this.name = name;
        }
    }

    Node root = new Node("");

    public _588() {

    }

    private Node dfs(String path) {
        Node node = root;
        for (String s : path.split("/")) {
            if (s.isEmpty())
                continue;
            if (!node.map.containsKey(s))
                node.map.put(s, new Node(s));
            node = node.map.get(s);
        }
        return node;
    }

    public List<String> ls(String path) {
        Node node = dfs(path);
        if (node.isFile)
            return Arrays.asList(node.name);
        else {
            List<String> list = new ArrayList<>(node.map.keySet());
            Collections.sort(list);
            return list;
        }
    }

    public void mkdir(String path) {
        dfs(path);
    }

    public void addContentToFile(String filePath, String content) {
        Node node = dfs(filePath);
        node.isFile = true;
        node.builder.append(content);
    }

    public String readContentFromFile(String filePath) {
        return dfs(filePath).builder.toString();
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */