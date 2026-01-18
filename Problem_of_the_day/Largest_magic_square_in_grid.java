/*
Title: Largest Magic Square in a Grid

Approach:
1. A k x k magic square is a square subgrid where:
   - Every row sum is equal
   - Every column sum is equal
   - Both diagonal sums are equal
2. To efficiently compute row sums and column sums:
   - Build rowPrefix[i][j+1] = sum of grid[i][0..j]
   - Build colPrefix[i+1][j] = sum of grid[0..i][j]
3. Try all possible square sizes k from largest to smallest:
   - For each top-left corner (r, c), check the k x k subgrid.
4. For each candidate subgrid:
   - Compute the target sum using the first row.
   - Check all k rows have the same sum using rowPrefix.
   - Check all k columns have the same sum using colPrefix.
   - Check both diagonals by direct summation.
5. If all conditions match, return k immediately (largest found first).
6. If no k >= 2 works, return 1 (every 1x1 square is magic).

Time Complexity:
- O(min(m, n) * m * n * k) in worst case
- For each size k, we may check many subgrids and validate k rows, k cols, and diagonals.

Space Complexity:
- O(m * n)
- Two prefix sum arrays: rowPrefix and colPrefix.
*/

class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // rowPrefix[i][j+1] = sum of grid[i][0..j]
        int[][] rowPrefix = new int[m][n + 1];
        // colPrefix[i+1][j] = sum of grid[0..i][j]
        int[][] colPrefix = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPrefix[i][j + 1] = rowPrefix[i][j] + grid[i][j];
                colPrefix[i + 1][j] = colPrefix[i][j] + grid[i][j];
            }
        }

        int ans = 1;

        // try bigger sizes first
        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int r = 0; r + k - 1 < m; r++) {
                for (int c = 0; c + k - 1 < n; c++) {

                    int target = getRowSum(rowPrefix, r, c, c + k - 1);

                    // check all rows
                    boolean ok = true;
                    for (int i = r; i < r + k && ok; i++) {
                        if (getRowSum(rowPrefix, i, c, c + k - 1) != target) ok = false;
                    }

                    // check all cols
                    for (int j = c; j < c + k && ok; j++) {
                        if (getColSum(colPrefix, j, r, r + k - 1) != target) ok = false;
                    }

                    // check diagonals
                    if (ok) {
                        int diag1 = 0, diag2 = 0;
                        for (int t = 0; t < k; t++) {
                            diag1 += grid[r + t][c + t];
                            diag2 += grid[r + t][c + k - 1 - t];
                        }
                        if (diag1 != target || diag2 != target) ok = false;
                    }

                    if (ok) return k;
                }
            }
        }

        return ans;
    }

    private int getRowSum(int[][] rowPrefix, int r, int c1, int c2) {
        return rowPrefix[r][c2 + 1] - rowPrefix[r][c1];
    }

    private int getColSum(int[][] colPrefix, int c, int r1, int r2) {
        return colPrefix[r2 + 1][c] - colPrefix[r1][c];
    }
}
