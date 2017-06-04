/**
 * LeetCode 605 - Can Place Flowers
 * <p>
 * Greedy
 */
public class _605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++)
            if (flowerbed[i] == 0) {
                if ((i - 1 < 0 || flowerbed[i - 1] == 0) && (i + 1 >= flowerbed.length || flowerbed[i + 1] == 0)) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        return n <= 0;
    }
}