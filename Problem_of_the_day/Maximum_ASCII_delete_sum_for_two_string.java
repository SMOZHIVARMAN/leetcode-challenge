/*
Title: Minimum ASCII Delete Sum for Two Strings

Approach:
1. This problem is a variation of the Longest Common Subsequence (LCS) concept,
   where instead of maximizing length, we minimize the ASCII delete cost.
2. Use Dynamic Programming to compute the minimum ASCII sum of deleted characters
   needed to make both strings equal.
3. Let dp[j] represent the minimum delete sum for:
   - s1[0..i-1] and s2[0..j-1]
4. Optimization:
   - Use a 1D DP array instead of a 2D array to reduce space usage.
   - Ensure s1 is the longer string to minimize DP size.
5. Initialization:
   - dp[j] stores the ASCII sum of deleting all characters from s2 up to j.
6. Transition:
   - If characters match, no deletion is needed → take previous diagonal value.
   - If characters don’t match:
       a) Delete character from s1
       b) Delete character from s2
     Take the minimum of both costs.
7. The final answer is stored in dp[n].

Time Complexity: O(m * n)
- Where m is the length of s1 and n is the length of s2.

Space Complexity: O(n)
- Uses a single DP array of size n + 1.
*/

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        if (m < n) {
            return minimumDeleteSum(s2, s1);
        }
        
        int[] dp = new int[n + 1];
        
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] + (int)s2.charAt(j - 1);
        }
        
        for (int i = 1; i <= m; i++) {
            int prev = dp[0];  
            dp[0] += (int)s1.charAt(i - 1);  
            
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = prev;  
                } else {
                    dp[j] = Math.min(
                        dp[j] + (int)s1.charAt(i - 1),
                        dp[j - 1] + (int)s2.charAt(j - 1)
                    );
                }
                prev = temp;  
            }
        }
        
        return dp[n];
    }
}