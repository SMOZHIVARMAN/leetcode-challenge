/*
Title: Separate Squares by Horizontal Line

Approach:
1. Each square is defined by:
   - s[1] → y-coordinate of the bottom side
   - s[2] → side length (l)
2. Compute:
   - Total area of all squares.
   - The lowest possible y (minimum bottom).
   - The highest possible y (maximum top).
3. The goal is to find a horizontal line y = h such that:
   - Area below h = Total area / 2.
4. Use Binary Search on y-coordinate:
   - Search range: [low, high]
   - For each mid:
     - Compute area covered below mid using `areaBelow()`.
     - If area < target → move up.
     - Else → move down.
5. Perform binary search for sufficient precision (80 iterations).
6. Return the minimum y that splits the area equally.

Helper Function (areaBelow):
- Calculates total area of all square portions lying below height h.
- Handles:
  - Completely below the line
  - Completely above the line
  - Partially intersecting the line

Time Complexity:
- O(n × log P)
  where:
  - n = number of squares
  - P = precision iterations (fixed at 80)

Space Complexity:
- O(1)
  Uses constant extra space.
*/

class Solution {

    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE, high = 0;

        // Calculate total area and search range
        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];
            totalArea += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double target = totalArea / 2.0;

        // Binary search for minimum y
        for (int i = 0; i < 80; i++) { // precision control
            double mid = (low + high) / 2.0;
            double areaBelow = areaBelow(squares, mid);

            if (areaBelow < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private double areaBelow(int[][] squares, double h) {
        double area = 0;

        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];

            if (h <= y) continue;
            else if (h >= y + l) area += l * l;
            else area += l * (h - y);
        }

        return area;
    }
}
