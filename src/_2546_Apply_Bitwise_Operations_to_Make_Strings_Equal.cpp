/**
 * LeetCode 2546 - Apply Bitwise Operations to Make Strings Equal
 *
 * Rules are
 * (0, 0) -> (0, 0)
 * (0, 1) -> (1, 1)
 * (1, 0) -> (1, 1)
 * (1, 1) -> (1, 0) or (0, 1)
 *
 * Basically, that means
 * (a) All 0-string cannot change at all.
 * (b) If a string contains at least a one in it, we cannot make it all 0-string
 *     That is, there must exist at least a one after any transformation.
 * (c) Otherwise, s can change freely.
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
public:
  bool makeStringsEqual(string s, string t) {
    return (s.find('1') != string::npos) == (t.find('1') != string::npos);
  }
};
