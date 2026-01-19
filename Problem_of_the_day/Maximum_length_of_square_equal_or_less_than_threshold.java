/*
Title: Maximum Side Length of a Square with Sum Less Than or Equal to Threshold

Approach:
1. Use Prefix Sum (2D cumulative sum) to quickly calculate the sum of any sub-square in O(1).
   - prefix[i][j] stores the sum of elements in the rectangle from (0,0) to (i-1,j-1).
   - Formula:
     prefix[i][j] = mat[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1]

2. Apply Binary Search on the answer (side length k):
   - Minimum side length = 0
   - Maximum side length = min(m, n)
   - For each mid value (candidate k):
       - Check if there exists at least one k x k square whose sum <= threshold.
       - If possible, try bigger k.
       - Otherwise, try smaller k.

3. Helper Function (canFindSquare):
   - For every possible top-left position of a k x k square,
     compute its sum using prefix sums in O(1).
   - If any square sum <= threshold, return true.

Time Complexity:
- Building prefix sum: O(m * n)
- Binary search: O(log(min(m, n)))
- Each check (canFindSquare): O((m - k + 1) * (n - k + 1)) ≈ O(m * n)
- Overall: O(m * n * log(min(m, n)))

Space Complexity:
- O(m * n) for prefix sum array.
*/

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        long[][] prefix = new long[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int left = 0, right = Math.min(m, n), ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFindSquare(prefix, m, n, mid, threshold)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canFindSquare(long[][] prefix, int m, int n, int k, int threshold) {
        for (int i = 1; i <= m - k + 1; i++) {
            for (int j = 1; j <= n - k + 1; j++) {
                long sum = prefix[i + k - 1][j + k - 1]
                         - prefix[i - 1][j + k - 1]
                         - prefix[i + k - 1][j - 1]
                         + prefix[i - 1][j - 1];

                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
