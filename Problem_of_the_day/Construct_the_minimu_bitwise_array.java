/*
Title: Minimum Bitwise Array

Approach:
1. For each number in the given list `nums`, we need to compute the minimum value `x`
   based on a bitwise transformation rule (implemented inside findMinX).
2. Create an integer array `ans` to store results for each element.
3. For each number:
   - Call findMinX(num) and store the returned value in ans[i].

Helper Method (findMinX):
1. Special Case:
   - If num == 2, return -1 (as per problem rule / not possible case).
2. Traverse bit positions from 1 to 31:
   - Check if the i-th bit of num is 0.
   - Once the first 0-bit is found at position i,
     flip the (i-1)-th bit using XOR:
       num ^ (1 << (i - 1))
   - Return the computed value immediately.
3. If no such position is found, return -1.

Time Complexity:
- For each number, we check at most 31 bits → O(31) ≈ O(1)
- For n numbers → O(n)

Space Complexity:
- O(n) for the output array `ans`
- O(1) extra space besides the output
*/

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            ans[i] = findMinX(nums.get(i));
        }

        return ans;
    }

    private int findMinX(int num) {
        if (num == 2) return -1;

        for (int i = 1; i <= 31; i++) {
            if (((num >> i) & 1) == 0) {
                return num ^ (1 << (i - 1));
            }
        }
        return -1;
    }
}
