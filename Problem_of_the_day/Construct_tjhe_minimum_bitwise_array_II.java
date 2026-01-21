/*
Title: Minimum Bitwise Array

Approach:
1. For each number x in the list `nums`, we need to find the minimum possible value
   based on a bitwise transformation rule.
2. Create an output array `ans` of the same size as `nums`.
3. For every element x:
   - If x == 2, directly store -1 (special case where answer is not possible).
   - Otherwise, scan bit positions from 1 to 31:
       a) Check if the j-th bit of x is 0.
       b) If found, flip the (j - 1)-th bit using XOR:
          ans[i] = x ^ (1 << (j - 1))
       c) Break immediately after finding the first valid bit.
   - If no such bit is found, store -1.

Time Complexity:
- O(n)
  For each number, we check at most 31 bits → O(31) ≈ O(1)
  Total for n elements → O(n)

Space Complexity:
- O(n)
  Output array `ans` stores results for all elements.
  Extra space apart from output is O(1).
*/

import java.util.*;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);

            if (x == 2) {
                ans[i] = -1;
            } else {
                boolean found = false;

                for (int j = 1; j < 32; j++) {
                    if (((x >> j) & 1) == 0) {
                        ans[i] = x ^ (1 << (j - 1));
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    ans[i] = -1;
                }
            }
        }
        return ans;
    }
}
