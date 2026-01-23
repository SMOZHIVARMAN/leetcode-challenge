/*
Title: Minimum Pair Removal to Make Array Non-Decreasing (Optimized with Linked Segments + TreeSet)

Approach:
1. Goal:
   - Perform minimum operations until the array becomes non-decreasing.
   - One operation = choose an adjacent pair and merge them into their sum.

2. Key Idea (Optimization):
   - Instead of scanning the whole array every time (O(n^2)),
     we maintain the array as a doubly linked list of "segments".
   - Each segment stores:
       value     → current merged value
       left/right → adjacent segments
       mergeCost → sum of this segment with its right neighbor

3. Violations Tracking:
   - A "violation" is when right.value < current.value (array not sorted).
   - Maintain a count `violations`.
   - When violations become 0, the sequence is sorted.

4. Choosing Best Merge:
   - Use a TreeSet (acts like a priority queue) storing segments based on:
       a) smallest mergeCost first
       b) tie-break by index
   - Always merge the segment with smallest mergeCost (greedy choice).

5. Merge Operation Steps:
   - Remove best segment and its right neighbor.
   - Merge them: best.value += next.value
   - Reconnect pointers:
       best.right = next.right
       update left pointers accordingly
   - Update mergeCost values for affected neighbors.
   - Adjust violations count carefully based on changes.

6. Repeat until violations == 0, counting operations.

Time Complexity:
- O(n log n)
  Explanation:
  - Building initial TreeSet: O(n log n)
  - Each merge involves a few TreeSet add/remove operations: O(log n)
  - Up to (n - 1) merges
  => Overall: O(n log n)

Space Complexity:
- O(n)
  - We store n Segment nodes and maintain them inside the TreeSet.
*/

class Solution {

    private static class Segment implements Comparable<Segment> {
        int index;
        long value;
        long mergeCost;
        Segment left;
        Segment right;

        Segment(int idx, long val) {
            index = idx;
            value = val;
        }

        @Override
        public int compareTo(Segment o) {
            if (right == null || o.right == null) {
                return right == null ? 1 : -1;
            }
            long diff = mergeCost - o.mergeCost;
            if (diff != 0) return diff < 0 ? -1 : 1;
            return index - o.index;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        TreeSet<Segment> heap = new TreeSet<>();
        int violations = 0;

        Segment current = null;

        // Build doubly linked list of segments and initialize merge costs
        for (int i = 0; i < nums.length; i++) {
            Segment node = new Segment(i, nums[i]);

            if (current != null) {
                if (node.value < current.value) violations++;

                current.right = node;
                node.left = current;

                current.mergeCost = current.value + node.value;
                heap.add(current);
            }
            current = node;
        }

        heap.add(current);

        int operations = 0;

        while (violations > 0) {
            operations++;

            Segment best = heap.pollFirst();
            Segment next = best.right;

            // Fix violations between best and next
            if (next.value < best.value) violations--;

            // Merge best and next
            best.value += next.value;
            best.mergeCost = best.value + (next.right != null ? next.right.value : 0);

            // Reconnect pointers after merge
            best.right = next.right;
            if (next.right != null) {
                if (next.right.value < next.value) violations--;
                next.right.left = best;
                if (best.value > next.right.value) violations++;
            }

            heap.remove(next);
            heap.add(best);

            // Update left neighbor relationship
            Segment prev = best.left;
            if (prev != null) {
                heap.remove(prev);

                if (prev.value > prev.mergeCost - prev.value) violations--;
                if (prev.value > best.value) violations++;

                prev.mergeCost = prev.value + best.value;
                prev.right = best;

                heap.add(prev);
            }
        }

        return operations;
    }
}
