/*
Title: Perfect Number Check

Approach:
1. A perfect number is a positive integer that is equal to the sum of its
   positive divisors (excluding itself).
   Example: 6 → 1 + 2 + 3 = 6
2. Instead of computing divisors, this solution uses the fact that within
   the 32-bit integer range, only a few perfect numbers exist.
3. Directly compare the given number with the known perfect numbers:
   6, 28, 496, 8128, 33550336
4. Return true if it matches any of them, otherwise false.

Time Complexity: O(1)
- Constant time comparisons.

Space Complexity: O(1)
- No extra space is used.
*/

class Solution {
    public boolean checkPerfectNumber(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }
}
