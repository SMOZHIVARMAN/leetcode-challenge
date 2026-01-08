 /*
Title: Maximum Dot Product of Two Subsequences

Approach:
1. Use dynamic programming to find the maximum dot product of non-empty subsequences from nums1 and nums2.
2. Create a DP table dp[m+1][n+1], where dp[i][j] represents the maximum dot product using the first i elements of nums1 and first j elements of nums2.
3. Initialize the first row and column with Integer.MIN_VALUE / 2 to handle negative numbers without overflow.
4. For each dp[i][j]:
   - Calculate the dot product of current elements: single = nums1[i-1] * nums2[j-1]
   - Take the maximum of:
     a) single (starting a new subsequence)
     b) dp[i-1][j] (skip current element of nums1)
     c) dp[i][j-1] (skip current element of nums2)
     d) dp[i-1][j-1] + single (extend previous subsequence if it's valid)
5. The final answer is dp[m][n], which gives the maximum dot product of two subsequences.

Time Complexity: O(m * n)
- Nested loops over both arrays.

Space Complexity: O(m * n)
- 2D DP table of size (m+1) x (n+1)
*/

 class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 0; i <= m; i++) dp[i][0] = Integer.MIN_VALUE / 2;
        for(int j = 1; j <= n; j++) dp[0][j] = Integer.MIN_VALUE / 2; 
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                int single = nums1[i-1] * nums2[j-1];
                dp[i][j] = Math.max(single, Math.max(dp[i-1][j], dp[i][j-1]));
                
                if(dp[i-1][j-1] > Integer.MIN_VALUE / 2 + 1000) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + single);
                }
            }
        }
        return dp[m][n];
    }
}