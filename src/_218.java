import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * LeetCode 218 - The Skyline Problem
 *
 * Same idea as the C++ solution, but written in Java.
 *
 * Say u is an element of a
 * Then, u is an endpoint point, where
 * u[0] is the x-coordinate,
 * u[1] is the y-coordinate,
 * u[2] = 0 if u is a left endpoint, u[2] = 1 if it is a right endpoint.
 */
public class _218 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ans = new ArrayList<>();
        List<int[]> a = new ArrayList<>(buildings.length * 2);
        for (int[] building : buildings) {
            a.add(new int[]{building[0], building[2], 0});
            a.add(new int[]{building[1], building[2], 1});
        }
        Collections.sort(a, (u, v) -> {
            if (u[0] != v[0]) return Integer.compare(u[0], v[0]);
            else if (u[2] != v[2]) return Integer.compare(u[2], v[2]);
            else if (u[2] == 0) return -Integer.compare(u[1], v[1]);
            else return Integer.compare(u[1], v[1]);
        });

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        for (int[] i : a) {
            int preMax = map.lastKey();
            if (i[2] == 0) map.put(i[1], map.getOrDefault(i[1], 0) + 1);
            else {
                map.put(i[1], map.get(i[1]) - 1);
                if (map.get(i[1]) == 0) map.remove(i[1]);
            }
            if (preMax != map.lastKey()) ans.add(new int[]{i[0], map.lastKey()});
        }
        return ans;
    }
}
