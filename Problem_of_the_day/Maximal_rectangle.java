/*
Title: Maximal Rectangle in a Binary Matrix

Approach:
1. Treat each row of the matrix as the base of a histogram.
2. Maintain an array `heights` where:
   - heights[j] represents the number of consecutive '1's
     in column j up to the current row.
3. For each row:
   - Update the `heights` array:
       a) If matrix[i][j] == '1', increment heights[j].
       b) Otherwise, reset heights[j] to 0.
   - Compute the largest rectangle area in the histogram
     formed by `heights`.
4. Use a stack-based algorithm to find the largest rectangle
   in a histogram in linear time.
5. Keep track of the maximum area found across all rows.

Time Complexity: O(rows * cols)
- Each cell is processed once while building heights.
- Histogram largest rectangle computation is O(cols) per row.

Space Complexity: O(cols)
- `heights` array uses O(cols) space.
- Stack used in histogram computation also uses O(cols) space.
*/

import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxarea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxarea = Math.max(maxarea, largestRectangleArea(heights));
        }
        return maxarea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxarea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currentheight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentheight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxarea = Math.max(maxarea, height * width);
            }
            stack.push(i);
        }

        return maxarea;
    }
}
