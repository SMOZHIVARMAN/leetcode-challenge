/*
Title: Check if a Number is Power of Four

Approach:
1. First, ensure the number is positive (n > 0).
2. Check if the number is a power of two:
   - A power of two has exactly one set bit.
   - This is verified using (n & (n - 1)) == 0.
3. Ensure that the single set bit is in an even position:
   - Powers of four have their only set bit at positions 0, 2, 4, ...
   - The bitmask 0xAAAAAAAA has 1s in all odd positions.
   - If (n & 0xAAAAAAAA) == 0, the set bit is not in an odd position,
     hence it must be a power of four.

Time Complexity: O(1)
- All bitwise operations take constant time.

Space Complexity: O(1)
- No extra space is used.

Note:
- This solution avoids loops and recursion, making it highly efficient.
*/

class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 
            && (n & (n - 1)) == 0 
            && (n & 0xAAAAAAAA) == 0;
    }
}
