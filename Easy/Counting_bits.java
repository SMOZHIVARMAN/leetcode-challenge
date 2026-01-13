/**
 * Title: Counting Bits
 *
 * Approach:
 * 1. Create an array ans of size n + 1 to store the count of 1-bits for each number.
 * 2. For each number i from 0 to n:
 *    - Right shift i by 1 (i >> 1) to get i / 2.
 *    - Use the already computed result ans[i >> 1].
 *    - Add (i & 1) to check if the last bit is 1.
 * 3. Store the result in ans[i].
 * 4. Return the array ans.
 *
 * Time Complexity:
 * O(n)
 * Each number from 0 to n is processed once.
 *
 * Space Complexity:
 * O(n)
 * Extra space is used for the output array.
 */

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
