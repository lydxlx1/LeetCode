import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 672 - Bulb Switcher II
 * <p>
 * Brute-force + Math
 * <p>
 * Some useful observations for this problem:
 * 1) If one button is pressed twice, it is equivalent as this button is not pressed at all.
 * 2) The order of button presses do not matter.
 * 3) Each m-element operation sequence can then be represented as a multiset.
 * 4) Given a multiset M of size m, we use [M] to denote the equivalent class that contains those operation sets with
 * the same side-effect.
 * 5) We can repeatedly apply 1) to get a minimal set (yes, set, a multiset is never minimal) from [M].
 * 6) The size of the minimal set is no more than 4, and the difference between the size of any element from [M] and
 * the size of the minimal set must be even.
 * 7) There can be at most 2^4 = 16 minimal sets.
 * <p>
 * Then the problem can be trivially solved by brute-force.
 */
class _672 {
    public int flipLights(int n, int m) {
        if (n == 0 || m == 0) {
            return 1;
        }

        BitSet all = new BitSet(n);
        BitSet odd = new BitSet(n);
        BitSet even = new BitSet(n);
        BitSet multipleOf3 = new BitSet(n);
        for (int i = 0; i < n; i++) {
            all.flip(i);
            if (i % 2 == 0) {
                even.flip(i);
            }
            if (i % 2 == 1) {
                odd.flip(i);
            }
            if (i % 3 == 0) {
                multipleOf3.flip(i);
            }
        }


        Set<BitSet> set = new HashSet<>();
        for (int mask = 0; mask < (1 << 4); mask++) {
            if (Integer.bitCount(mask) <= m && (m - Integer.bitCount(mask)) % 2 == 0) {
                BitSet bits = new BitSet(n);
                if ((mask & 1) != 0) {
                    bits.xor(all);
                }
                if ((mask & 2) != 0) {
                    bits.xor(odd);
                }
                if ((mask & 4) != 0) {
                    bits.xor(even);
                }
                if ((mask & 8) != 0) {
                    bits.xor(multipleOf3);
                }

                set.add(bits);
            }
        }
        return set.size();
    }
}