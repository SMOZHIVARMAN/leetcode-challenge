/*
Title: Minimize Maximum Pair Sum in Array

Approach:
1. Sort the array in ascending order.
2. Use two pointers:
   - left at the beginning (smallest element)
   - right at the end (largest element)
3. Pair the smallest and largest elements together:
   - This balances the pair sums and helps minimize the maximum pair sum.
4. For each pair:
   - Calculate pairSum = nums[left] + nums[right]
   - Track the maximum pair sum among all pairs.
5. Return the maximum pair sum found (this will be the minimized maximum).

Time Complexity:
- O(n log n)
  Sorting takes O(n log n), and pairing takes O(n).

Space Complexity:
- O(1)
  Uses constant extra space (ignoring sorting internal space).
*/

import java.util.*;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        int sum = 0;

        while (left < right) {
            sum = Math.max(sum, nums[left] + nums[right]);
            left++;
            right--;
        }

        return sum;
    }
}
