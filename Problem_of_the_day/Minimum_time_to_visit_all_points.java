/*
Title: Minimum Time to Visit All Points

Approach:
1. The time to move between two points on a 2D plane is determined by:
   - Moving horizontally, vertically, or diagonally.
2. The minimum time required to move from point A to point B is:
   max(|x2 - x1|, |y2 - y1|)
   because diagonal movement covers both directions in one step.
3. Iterate through the list of points:
   - For each consecutive pair of points, calculate dx and dy.
   - Add the maximum of dx and dy to the total time.
4. Return the accumulated total time.

Time Complexity: O(n)
- n is the number of points.

Space Complexity: O(1)
- Only constant extra space is used.
*/

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totaltime = 0;
        
        for (int i = 0; i < points.length - 1; i++) {
            int dx = Math.abs(points[i][0] - points[i + 1][0]);
            int dy = Math.abs(points[i][1] - points[i + 1][1]);
            totaltime += Math.max(dx, dy);
        }
        
        return totaltime;
    }
}
