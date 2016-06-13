/**
 * LeetCode 357 - Count Numbers with Unique Digits
 *
 * Product Rule
 *
 * To generate a number with n unique digits, we have
 * 9 choices for the 1st most significant bit, // since the first digit cannot be equal to 0
 * 9 choices for the 2nd most significant bit,
 * 8 choices for the 3rd most significant bit,
 * 7 choices for the 4th most significant bit,
 * ...
 * 11 - n choices for the nth most significant bit,
 *
 * Then, we apply produce rule to multiply all the above
 */
public class _357 {
    public int countNumbersWithUniqueDigits(int n) {
        int ans = 0, prod = 9, factor = 9;
        for (int i=0; i<n; i++) {
            ans += prod;
            prod *= factor--;
        }
        return ans + 1; // 0 is always a candidate
    }
}