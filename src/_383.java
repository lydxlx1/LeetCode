import java.util.Arrays;

/**
 * LeetCode 383 - Ransom Note
 *
 * Simple solution
 */
public class _383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[128];
        for (int i = 0; i < magazine.length(); i++) cnt[magazine.charAt(i)]++;
        for (int i = 0; i < ransomNote.length(); i++)
            if (--cnt[ransomNote.charAt(i)] < 0) return false;
        return true;
    }
}