import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 850 - Rectangle Area II
 * <p>
 * Rectangle Cutting
 */
public class _850 {

    public int rectangleArea(int[][] rectangles) {
        List<int[]> rec = new ArrayList<>();

        for (int[] each : rectangles) {
            rec.add(each);
        }

        long totalArea = 0;
        long mod = 1000000007;
        while (!rec.isEmpty()) {
            int which = 0;
            // Heuristic: Larger rectangle usually cuts the remaining rectangles into less number of pieces.
            long largestArea = 0;
            for (int i = 0; i < rec.size(); i++) {
                int[] current = rec.get(0);
                long area = (long) (current[2] - current[0]) * (current[3] - current[1]);
                if (area > largestArea) {
                    largestArea = area;
                    which = i;
                }
            }
            totalArea += largestArea % mod;
            totalArea %= mod;


            // For each remaining rectangle, we remove the largest rectangle region from it and cut it into at most four pieces.
            //
            //          |     |
            //          | (D) |
            //          |     |
            //          +-----+
            //          |     |
            // <---(A)  |  *  |   (B)--->
            //          |     |
            //          |     |
            //          +-----+
            //          |     |
            //          | (C) |
            //          |     |
            //

            List<int[]> newRec = new ArrayList<>();
            int[] current = rec.get(which);
            for (int i = 0; i < rec.size(); i++) {
                if (i == which) {
                    continue;
                }

                int[] next = rec.get(i);
                int x1 = current[0], x2 = current[2], y1 = current[1], y2 = current[3];

                {
                    int xx1 = next[0], xx2 = next[2], yy1 = next[1], yy2 = next[3];
                    xx2 = Math.min(xx2, x1);
                    if (xx1 < xx2) {
                        newRec.add(new int[]{xx1, yy1, xx2, yy2});
                    }
                }
                {
                    int xx1 = next[0], xx2 = next[2], yy1 = next[1], yy2 = next[3];
                    xx1 = Math.max(xx1, x2);
                    if (xx1 < xx2) {
                        newRec.add(new int[]{xx1, yy1, xx2, yy2});
                    }
                }
                {
                    int xx1 = next[0], xx2 = next[2], yy1 = next[1], yy2 = next[3];
                    xx1 = Math.max(xx1, x1);
                    xx2 = Math.min(xx2, x2);
                    yy2 = Math.min(yy2, y1);
                    if (yy1 < yy2) {
                        newRec.add(new int[]{xx1, yy1, xx2, yy2});
                    }
                }
                {
                    int xx1 = next[0], xx2 = next[2], yy1 = next[1], yy2 = next[3];
                    xx1 = Math.max(xx1, x1);
                    xx2 = Math.min(xx2, x2);
                    yy1 = Math.max(yy1, y2);
                    if (yy1 < yy2) {
                        newRec.add(new int[]{xx1, yy1, xx2, yy2});
                    }
                }
            }

            rec = newRec;
        }

        return (int) totalArea;
    }
}

