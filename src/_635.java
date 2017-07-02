import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 635 - Design Log Storage System
 * <p>
 * Brute-force + Lexicographical order
 */
public class _635 {

    private Map<Integer, String> map;

    public _635() {
        map = new HashMap<>();
    }

    public void put(int id, String timestamp) {
        map.put(id, timestamp);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        int prefixLength = prefixLength(gra);
        s = s.substring(0, prefixLength);
        e = e.substring(0, prefixLength);
        List<Integer> res = new ArrayList<>();
        for (int i : map.keySet()) {
            String str = map.get(i).substring(0, prefixLength);
            if (str.compareTo(s) >= 0 && str.compareTo(e) <= 0)
                res.add(i);
        }
        return res;
    }

    private int prefixLength(String gra) {
        if (gra.equalsIgnoreCase("year")) return 4;
        else if (gra.equalsIgnoreCase("month")) return 7;
        else if (gra.equalsIgnoreCase("day")) return 10;
        else if (gra.equalsIgnoreCase("hour")) return 13;
        else if (gra.equalsIgnoreCase("minute")) return 16;
        else return 19;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */