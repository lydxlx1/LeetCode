import java.util.*;

/**
 * LeetCode 691 - Stickers to Spell Word
 * <p>
 * A pretty nice DP problem.
 * Different from the faster solution in the LeetCode discussion session, I am doing some offline optimization to the
 * inputs.
 * <p>
 * 1) Order here is totally useless, so we can sort all stickers and the target.
 * 2) Once all the strings are sorted, each DP transit can be done in linear time (i.e., O(|target| + |sticker|)) via
 * a standard merging step.
 * 3) Characters from stickers that do not appear in target are useless and thus can be removed.
 * 4) After the above removal, if one sticker is the subsequence of another, this sticker is useless.
 * (This assumes that presorting are done beforehand.)
 */
public class _691 {
    public int minStickers(String[] stickers, String target) {
        if (stickers.length == 0)
            return 0;

        char[] chars = target.toCharArray();
        Arrays.sort(chars);
        target = String.valueOf(chars);
        stickers = getMinimalStickers(stickers, target);

        final int INF = 1 << 29;
        int[] f = new int[1 << target.length()];
        for (int mask = 1; mask < f.length; mask++) {
            f[mask] = INF;
            for (String sticker : stickers) {
                int newMask = mask;
                // If we have sorted both sticker and target, we can reduce the runtime by doing a linear merging.
                for (int i = 0, j = 0; i < sticker.length() && j < target.length(); )
                    if (sticker.charAt(i) < target.charAt(j))
                        i++;
                    else if (sticker.charAt(i) > target.charAt(j))
                        j++;
                    else {
                        if ((mask & (1 << j)) != 0) {
                            i++;
                            newMask ^= 1 << j;
                        }
                        j++;
                    }
                f[mask] = Math.min(f[mask], f[newMask] + 1);
            }
        }
        return f[f.length - 1] == INF ? -1 : f[f.length - 1];
    }

    private String[] getMinimalStickers(String[] stickers, String target) {
        int mask = 0;
        for (char ch : target.toCharArray())
            mask |= 1 << (ch - 'a');
        Set<String> cands = new HashSet<>();
        for (String sticker : stickers) {
            StringBuilder builder = new StringBuilder();
            for (char ch : sticker.toCharArray())
                if (((1 << (ch - 'a')) & mask) != 0)
                    builder.append(ch);
            char[] chars = builder.toString().toCharArray();
            Arrays.sort(chars);
            cands.add(String.valueOf(chars));
        }

        List<String> res = new ArrayList<>();
        for (String sticker : cands) {
            boolean keep = true;
            for (String another : res)
                if (isSubsequence(sticker, another)) {
                    keep = false;
                    break;
                }
            if (keep)
                res.add(sticker);
        }
        return res.stream().toArray(String[]::new);
    }

    private boolean isSubsequence(String src, String des) {
        for (int i = 0, j = 0; i < src.length() && j < des.length(); j++)
            if (src.charAt(i) == des.charAt(j)) {
                if (i == src.length() - 1) return true;
                i++;
            }
        return false;
    }

    public static void main(String[] args) {
        _691 sol = new _691();
        System.out.println(sol.minStickers(new String[]{"with", "example", "science"}, "thehat"));
        System.out.println(sol.minStickers(new String[]{"notice", "possible"}, "basicbasic"));
    }
}
