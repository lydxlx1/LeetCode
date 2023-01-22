/**
 * LeetCode 2544. Alternating Digit Sum
 */
class Solution {
public:
  int alternateDigitSum(int n) {
    string s = to_string(n);
    int ans = 0, sign = 1;
    for (char ch: s) {
      ans += sign * (ch - '0');
      sign = -sign;
    }
    return ans;
  }
};
