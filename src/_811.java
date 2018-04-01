import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 811 - Subdomain Visit Count
 */
public class _811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] tokens = cpdomain.split("[ ]+");
            int cnt = Integer.parseInt(tokens[0].trim());

            String domain = tokens[1].trim();
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String subdomain = domain.substring(i + 1);
                    map.put(subdomain, map.getOrDefault(subdomain, 0) + cnt);
                }
            }
            map.put(domain, map.getOrDefault(domain, 0) + cnt);
        }

        List<String> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(String.format("%d %s", map.get(key), key));
        }
        return ans;
    }
}
