import java.util.*;

/**
 * LeetCode 391 - Perfect Rectangle
 *
 * Sweepline + 1D Dynamic Segments Intersection
 *
 * The rectangle is perfect if and only if
 * 1) no two rectangles overlap,
 * 2) total area is equal to the area of the minimum bounding box.
 *
 * Assume we have a black box that supports the following operations:
 * 1) insert a segment (start, end), both exclusive, where the segment doesn't overlap with any existing ones,
 * 2) remove an existing segment (start, end),
 * 3) query whether there are two segments overlapping with each other.
 *
 * Using this black box, detecting whether there exists two overlapping rectangles can be solved
 * via a sweepline algorithm in O(n log n) time.
 */
public class _391 {

    private long A(int[] a) {
        return ((long) a[2] - a[0]) * ((long) a[3] - a[1]);
    }

    public boolean isRectangleCover(int[][] a) {
        long area = 0;
        int[] extreme = a[0].clone();
        for (int[] anA : a) {
            extreme[0] = Math.min(extreme[0], anA[0]);
            extreme[1] = Math.min(extreme[1], anA[1]);
            extreme[2] = Math.max(extreme[2], anA[2]);
            extreme[3] = Math.max(extreme[3], anA[3]);
            area += A(anA);
        }
        if (area != A(extreme)) return false;

        int[][] endPoints = new int[a.length * 2][2];
        for (int i = 0; i < a.length; i++) {
            endPoints[i][0] = endPoints[a.length + i][0] = i;
            endPoints[i][1] = 0;
            endPoints[a.length + i][1] = 1;
        }
        Arrays.sort(endPoints, (u, v) -> {
            int x1 = a[u[0]][2 * u[1]], x2 = a[v[0]][2 * v[1]];  // a[.][0], a[.][2] are slots for x-coordinates
            if (x1 != x2) return Integer.compare(x1, x2);
            else return -Integer.compare(u[1], v[1]); // put end points before start points if they share the same x-coordinates
        });
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int[] endPoint : endPoints) {
            int type = endPoint[1], y1 = a[endPoint[0]][1], y2 = a[endPoint[0]][3];
            if (type == 0) {
                Integer y;
                if ((y = tree.floorKey(y1)) != null && tree.get(y) > y1) return false;
                if ((y = tree.ceilingKey(y1)) != null && y < y2) return false;
                tree.put(y1, y2);
            } else tree.remove(y1);
        }
        return true;
    }
}
