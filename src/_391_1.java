import java.util.*;

/**
 * LeetCode 391 - Perfect Rectangle
 *
 * This is a standard solution using Segment Tree.
 *
 * Typically, Segment Tree can solved at least the following relevant questions.
 * 1) compute rectangle union area
 * 2) compute rectangle union perimeter
 * 3) detect rectangle interesections
 */
public class _391_1 {

    class Event implements Comparable<Event> {
        int x, y1, y2, type;
        int xxx; // the x-coordinate of the corresponding left endpoint if this is a right endpoint.

        public Event(int x, int y1, int y2, int type, int xxx) {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.type = type;
            this.xxx = xxx;
        }

        @Override
        public int compareTo(Event o) {
            if (x != o.x) return Integer.compare(x, o.x);
            else return Integer.compare(type, o.type);
        }
    }

    List<Integer> list;
    int[] begin, end, cnt, push;

    void build(int i, int left, int right) {
        begin[i] = left;
        end[i] = right;
        if (left < right) {
            int mid = (left + right) / 2;
            build(2 * i, left, mid);
            build(2 * i + 1, mid + 1, right);
        }
    }

    void push(int i) {
        cnt[i] += push[i] * (end[i] - begin[i] + 1);
        if (begin[i] < end[i]) {
            push[2 * i] += push[i];
            push[2 * i + 1] += push[i];
        }
        push[i] = 0;
    }

    int left, right;
    boolean newFlag;

    void update(int left, int right, boolean newFlag) {
        this.left = left;
        this.right = right;
        this.newFlag = newFlag;
        update(1);
    }

    void update(int i) {
        push(i);
        if (right < begin[i] || left > end[i]) return;
        if (left <= begin[i] && end[i] <= right) {
            push[i] = newFlag ? 1 : -1;
            push(i);
        } else {
            update(2 * i);
            update(2 * i + 1);
            cnt[i] = cnt[2 * i] + cnt[2 * i + 1];
        }
    }

    int query(int left, int right) {
        this.left = left;
        this.right = right;
        return query(1);
    }

    int query(int i) {
        push(i);
        if (right < begin[i] || left > end[i]) return 0;
        if (left <= begin[i] && end[i] <= right) return cnt[i];
        else return query(2 * i) + query(2 * i + 1);
    }

    public boolean isRectangleCover(int[][] a) {
        long minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        long maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        int n = a.length;
        int ptr = 0;
        list = new ArrayList<>(2 * n);
        Event[] events = new Event[2 * n];
        for (int i = 0; i < a.length; i++) {
            a[i][2]--;
            a[i][3]--;

            list.add(a[i][1]);
            list.add(a[i][3]);

            minX = Math.min(minX, a[i][0]);
            minY = Math.min(minY, a[i][1]);
            maxX = Math.max(maxX, a[i][2]);
            maxY = Math.max(maxY, a[i][3]);
        }

        list = new ArrayList(new TreeSet<>(list)); // sort and dedup
        for (int i = 0; i < n; i++) {
            events[ptr++] = new Event(a[i][0], Collections.binarySearch(list, a[i][1]), Collections.binarySearch(list, a[i][3]), 0, a[i][0]);
            events[ptr++] = new Event(a[i][2], Collections.binarySearch(list, a[i][1]), Collections.binarySearch(list, a[i][3]), 1, a[i][0]);
        }
        Arrays.sort(events);

        long area = 0;
        begin = new int[4 * list.size()];
        end = new int[4 * list.size()];
        push = new int[4 * list.size()];
        cnt = new int[4 * list.size()];

        build(1, 0, list.size() - 1);
        for (Event e : events) {
            System.out.println(e.x);
            if (e.type == 0) {
                if (query(e.y1, e.y2) > 0) return false;
                update(e.y1, e.y2, true);
            } else {
                area += ((long) e.x - e.xxx + 1) * (list.get(e.y2) - list.get(e.y1) + 1);
                update(e.y1, e.y2, false);
            }
        }
        return area == (maxX - minX + 1) * (maxY - minY + 1);
    }
}
