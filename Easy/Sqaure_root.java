/*
Title: Compute Integer Square Root

Approach:
1. Use Java’s built-in Math.sqrt() method to compute the square root of x.
2. The Math.sqrt() method returns a double value.
3. Typecast the result to an integer, which automatically truncates the decimal part.
4. The truncated value represents the integer square root of x.

Time Complexity: O(1)
- Math.sqrt() runs in constant time.

Space Complexity: O(1)
- No extra space is used; only constant variables.

Note:
- This approach relies on built-in library functions.
- For interview scenarios, a binary search solution is often preferred
  to demonstrate algorithmic understanding without using Math.sqrt().
*/

class Solution {
    public int mySqrt(int x) {
        return ((int)Math.sqrt(x));
    }
}