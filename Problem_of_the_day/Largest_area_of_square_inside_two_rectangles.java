/*
Title: Find the Largest Area of Square Inside Two Rectangles

Approach:
1. Each rectangle is given by its bottom-left and top-right coordinates.
2. To find the square that can fit inside the intersection of at least two rectangles:
   - Check every pair of rectangles (i, j).
   - Compute their overlapping (intersection) region:
       left   = max(ax1, bx1)
       bottom = max(ay1, by1)
       right  = min(ax2, bx2)
       top    = min(ay2, by2)
   - The intersection width  = right - left
   - The intersection height = top - bottom
3. If width > 0 and height > 0, intersection exists.
4. The largest square side that can fit in this intersection is:
   side = min(width, height)
5. Area of that square = side * side.
6. Track the maximum such square area among all rectangle pairs.

Time Complexity: O(n^2)
- We compare every pair of rectangles.

Space Complexity: O(1)
- Only constant extra variables are used.
*/

class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int ax1 = bottomLeft[i][0];
            int ay1 = bottomLeft[i][1];
            int ax2 = topRight[i][0];
            int ay2 = topRight[i][1];

            for (int j = i + 1; j < n; j++) {
                int bx1 = bottomLeft[j][0];
                int by1 = bottomLeft[j][1];
                int bx2 = topRight[j][0];
                int by2 = topRight[j][1];

                int left = Math.max(ax1, bx1);
                int bottom = Math.max(ay1, by1);
                int right = Math.min(ax2, bx2);
                int top = Math.min(ay2, by2);

                int width = right - left;
                int height = top - bottom;

                if (width > 0 && height > 0) {
                    long side = Math.min(width, height);
                    ans = Math.max(ans, side * side);
                }
            }
        }
        return ans;
    }
}