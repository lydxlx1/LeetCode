/**
 * LeetCode 2543 - Check if Point Is Reachable
 *
 * Math
 *
 * Conclusion: (1, 1) can be transformed to (x, y) if and only
 * gcd(x, y) is a power of 2.
 *
 * Brief ideas:
 * 1. It is easier to think backwards, i.e., transform (x, y) to (1, 1).
 * 2. Then the four operations become
 *    (x, y) -> (x, x + y)
 *    (x, y) -> (x + y, y)
 *    (x, y) -> (x / 2, y), if x is even
 *    (x, y) -> (x, y / 2), if y is even
 *
 * This means that if f > 2 is a common prime divisor of both x and y, then
 * f divides x + y, x / 2 (if x is even), and y / 2 (if y is even).
 *
 * This means that "x and y do NOT have any prime factor bigger than 2"
 * is a necessary condition to "be able to transform (x, y) to (1, 1)"
 *
 * To see the sufficient part, the code below shows one way to construct
 * the sequence (in reversed order).
 */
class Solution {
public:
  bool isReachable(int x, int y) {
    int g = gcd(x, y);
    if ((g & (g - 1)) != 0) {
      // check gcd is a power of 2.
      return false;
    }

    // Now, let's construct a solution
    while (x != 1 || y != 1) {
      if (x % 2 == 0) {
        x /= 2;
        continue;
      }
      if (y % 2 == 0) {
        y /= 2;
        continue;
      }
      if (x > y) swap(x, y);
      assert (x < y && (x + y) % 2 == 0);
      int z = (x + y) / 2;
      assert (x < z && z < y);
      y = z;
    }
    assert (x == 1 && y == 1);
    return true;
  }
};
