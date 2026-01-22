/*
Title: Minimum Pair Removal to Make Array Non-Decreasing

Approach:
1. We need to perform operations until the array becomes sorted (non-decreasing).
2. In one operation:
   - Find the adjacent pair with the minimum sum.
   - Replace that pair with a single element equal to their sum
     (effectively removing one element from the array).
3. Steps:
   - While the array length is greater than 1:
       a) If the array is already sorted, return the current operation count.
       b) Find the adjacent pair having the smallest sum.
       c) Create a new array of size (old length - 1):
           - Copy elements normally
           - When reaching the minimum-sum pair index, insert their sum once
             and skip the next element.
       d) Update nums to this new array and increment the operation count.
4. Return the number of operations performed.

Helper Function (isSorted):
- Checks if the array is non-decreasing by verifying nums[i] <= nums[i+1]
  for all valid indices.

Time Complexity:
- O(n^2) (Worst Case)
  Explanation:
  - Each operation scans the array to check sorted: O(n)
  - Finds minimum adjacent sum: O(n)
  - Builds a new array: O(n)
  - Number of operations can be up to (n - 1)
  => Total worst case: O(n * n) = O(n^2)

Space Complexity:
- O(n)
  A new array is created in each operation (temporary), so extra space is linear.
*/

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int ops = 0;

        while (nums.length > 1) {
            if (isSorted(nums)) {
                return ops;
            }

            int minsum = Integer.MAX_VALUE;
            int minindx = -1;

            // Find adjacent pair with minimum sum
            for (int i = 0; i < nums.length - 1; i++) {
                int currsum = nums[i] + nums[i + 1];
                if (currsum < minsum) {
                    minsum = currsum;
                    minindx = i;
                }
            }

            // Create new array after merging that minimum pair
            int[] newnums = new int[nums.length - 1];
            for (int i = 0, j = 0; i < nums.length; i++) {
                if (i == minindx) {
                    newnums[j++] = minsum;
                    i++; // skip the next element (pair merged)
                } else {
                    newnums[j++] = nums[i];
                }
            }

            nums = newnums;
            ops++;
        }

        return ops;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
