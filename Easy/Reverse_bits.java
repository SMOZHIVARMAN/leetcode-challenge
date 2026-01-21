/*
Title: Reverse Bits (32-bit Integer)

Approach:
1. Initialize `result` as 0.
2. Repeat 32 times (since integer has 32 bits):
   - Left shift result by 1 to make space for the next bit.
   - Extract the last bit of n using (n & 1).
   - Add this extracted bit to result using OR operation.
   - Right shift n by 1 to process the next bit.
3. After 32 iterations, `result` will contain the reversed bit representation.
4. Return result.

Time Complexity: O(1)
- Always runs for 32 iterations (constant time).

Space Complexity: O(1)
- Uses only constant extra variables.
*/

class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }

        return result;
    }
}
