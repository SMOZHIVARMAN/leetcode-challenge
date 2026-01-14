/**
 * Title: Separate Squares II (Union Area Split using Sweep Line)
 *
 * Approach:
 * 1. Treat each square as two horizontal events:
 *    - Add event at y (bottom of square)
 *    - Remove event at y + side length (top of square)
 *
 * 2. Use a Sweep Line technique moving vertically along the y-axis.
 *    - Maintain active x-intervals using a Segment Tree.
 *    - The segment tree keeps track of the total covered x-length at any y-level.
 *
 * 3. First Sweep:
 *    - Calculate the total union area by summing:
 *      (covered x-length) × (difference between consecutive y-values).
 *
 * 4. Second Sweep:
 *    - Repeat the sweep to find the minimum y-coordinate where
 *      the accumulated area reaches half of the total area.
 *    - Interpolate within the slab to get the exact y-value.
 *
 * 5. Segment Tree:
 *    - Uses coordinate compression on x-values.
 *    - Each node tracks coverage count and covered length.
 *
 * Time Complexity:
 * O(N log N)
 * - Sorting events: O(N log N)
 * - Each update/query on segment tree: O(log N)
 * - Total events: 2N
 *
 * Space Complexity:
 * O(N)
 * - Events list
 * - Segment tree
 * - Coordinate compression arrays
 */

import java.util.*;

class Solution {

    static class Event {
        long y;
        int x1, x2;
        int type; // +1 add, -1 remove

        Event(long y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegmentTree {
        int n;
        int[] count;
        long[] length;
        long[] xs;

        SegmentTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            count = new int[4 * n];
            length = new long[4 * n];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (ql >= r || qr <= l) return;

            if (ql <= l && r <= qr) {
                count[node] += val;
            } else {
                int mid = (l + r) / 2;
                update(node * 2, l, mid, ql, qr, val);
                update(node * 2 + 1, mid, r, ql, qr, val);
            }

            if (count[node] > 0) {
                length[node] = xs[r] - xs[l];
            } else if (l + 1 == r) {
                length[node] = 0;
            } else {
                length[node] = length[node * 2] + length[node * 2 + 1];
            }
        }

        void update(int l, int r, int val) {
            update(1, 0, n, l, r, val);
        }

        long query() {
            return length[1];
        }
    }

    public double separateSquares(int[][] squares) {
        int n = squares.length;
        List<Event> events = new ArrayList<>();
        Set<Long> xSet = new HashSet<>();

        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, (int) x, (int) (x + l), 1));
            events.add(new Event(y + l, (int) x, (int) (x + l), -1));
            xSet.add(x);
            xSet.add(x + l);
        }

        long[] xs = xSet.stream().sorted().mapToLong(Long::longValue).toArray();
        Map<Long, Integer> xIndex = new HashMap<>();
        for (int i = 0; i < xs.length; i++) {
            xIndex.put(xs[i], i);
        }

        events.sort(Comparator.comparingLong(e -> e.y));
        SegmentTree st = new SegmentTree(xs);

        double totalArea = 0;
        long prevY = events.get(0).y;

        for (Event e : events) {
            long currY = e.y;
            totalArea += st.query() * (currY - prevY);
            st.update(xIndex.get((long) e.x1), xIndex.get((long) e.x2), e.type);
            prevY = currY;
        }

        double half = totalArea / 2.0;
        st = new SegmentTree(xs);
        double currArea = 0;
        prevY = events.get(0).y;

        for (Event e : events) {
            long currY = e.y;
            double slabArea = st.query() * (currY - prevY);

            if (currArea + slabArea >= half) {
                double dy = (half - currArea) / st.query();
                return prevY + dy;
            }

            currArea += slabArea;
            st.update(xIndex.get((long) e.x1), xIndex.get((long) e.x2), e.type);
            prevY = currY;
        }

        return prevY;
    }
}
