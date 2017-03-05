import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 533 - Lonely Pixel II
 * <p>
 * Just need to correctly understand the problem description.
 */
public class _533 {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) return 0;

        Map<String, Integer> map = new HashMap<>();
        for (char[] str : picture) {
            String s = String.copyValueOf(str);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int[] c = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++)
            for (int j = 0; j < picture[i].length; j++)
                if (picture[i][j] == 'B') c[j]++;

        int ans = 0;
        for (String s : map.keySet()) {
            int r = 0, value = map.get(s);
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == 'B') r++;
            if (r != N || value != N) continue;
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == 'B' && c[i] == N) ans += value;
        }
        return ans;
    }


    public static void main(String[] args) {
        _533 sol = new _533();
        System.out.println(sol.findBlackPixel(new char[][]{
//                "WBWBBW".toCharArray(),"BWBWWB".toCharArray(),"WBWBBW".toCharArray(),"BWBWWB".toCharArray(),"WWWBBW".toCharArray(),"BWBWWB".toCharArray()},
                        "WBWBBW".toCharArray(), "WBWBBW".toCharArray(), "WBWBBW".toCharArray(), "WWBWBW".toCharArray()},
                3));
    }
}