/*
Title: Power Function (x^n)

Approach:
1. Use Java's built-in Math.pow(x, n) function to compute x raised to the power n.
2. Since n is an integer, it is typecast to double before passing into Math.pow().
3. Return the computed result.

Time Complexity: O(1)
- Math.pow() runs in constant time at a high level.

Space Complexity: O(1)
- No extra space is used.

Note:
- This solution uses a library method.
- In interviews, an optimized approach using fast exponentiation (binary exponentiation)
  is usually expected with O(log n) time.
*/

class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x, (double) n);
    }
}
