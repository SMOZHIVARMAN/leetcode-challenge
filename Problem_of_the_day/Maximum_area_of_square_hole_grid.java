/**
 * Title: Maximum Square Hole Area by Removing Bars
 *
 * Approach:
 * 1. A square hole can be formed only if we remove consecutive horizontal bars
 *    and consecutive vertical bars.
 * 2. The side length of the square is determined by:
 *    min(max consecutive horizontal bars removed,
 *        max consecutive vertical bars removed) + 1
 * 3. Steps:
 *    - Find the maximum number of consecutive removable horizontal bars.
 *    - Find the maximum number of consecutive removable vertical bars.
 *    - The side of the largest square is the minimum of the above two + 1.
 *    - Return side × side as the maximum square hole area.
 *
 * Helper Method (maxRemovable):
 * - Sort the bars array.
 * - Count the longest sequence of consecutive integers.
 * - This represents the maximum number of bars that can be removed continuously.
 *
 * Time Complexity:
 * O(H log H + V log V)
 * - Sorting horizontal bars: O(H log H)
 * - Sorting vertical bars: O(V log V)
 *
 * Space Complexity:
 * O(1)
 * - Uses constant extra space (sorting is in-place).
 */

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = maxRemovable(hBars);
        int maxV = maxRemovable(vBars);

        int side = Math.min(maxH, maxV) + 1;
        return side * side;
    }
    
    private int maxRemovable(int[] bars) {
        if (bars.length == 0) return 0;

        Arrays.sort(bars);
        int maxConsec = 1;
        int curr = 1;

        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                curr++;
                maxConsec = Math.max(maxConsec, curr);
            } else {
                curr = 1;
            }
        }
        return maxConsec;
    }
}