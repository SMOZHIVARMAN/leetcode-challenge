/*
Title: Minimum Difference Between Highest and Lowest of K Scores

Approach:
1. If k == 1, the difference will always be 0 because only one score is selected.
2. Sort the array in ascending order.
3. Use a sliding window of size k:
   - For each window, the minimum score is nums[i]
   - The maximum score is nums[i + k - 1]
   - Compute difference = nums[i + k - 1] - nums[i]
4. Track the minimum difference among all windows.
5. Return the minimum difference.

Time Complexity:
- O(n log n)
  Sorting the array takes O(n log n).
  Sliding window scan takes O(n).

Space Complexity:
- O(1)
  Extra space used is constant (ignoring sorting internal space).
*/

import java.util.*;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;

        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
        }

        return minDiff;
    }
}
