/*
Title: Check if a Number is Power of Two

Approach:
1. A number is a power of two if:
   - It is greater than 0.
   - It has exactly one set bit (1) in its binary representation.
2. Using bit manipulation:
   - For any power of two n, (n & (n - 1)) becomes 0.
     Example:
     n = 8  -> 1000
     n-1=7  -> 0111
     AND    -> 0000  ✅
3. Return true if both conditions are satisfied, otherwise false.

Time Complexity: O(1)
- Uses constant time bitwise operations.

Space Complexity: O(1)
- No extra space is used.
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
