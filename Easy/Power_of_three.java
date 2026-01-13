/**
 * Title: Power of Three
 *
 * Approach:
 * 1. If n is equal to 1, return true because 3⁰ = 1.
 * 2. If n is less than or equal to 0, return false since powers of three are positive.
 * 3. While n is greater than 1:
 *    - If n is not divisible by 3, it cannot be a power of three → return false.
 *    - Otherwise, divide n by 3.
 * 4. After the loop, check if n has become exactly 1.
 * 5. Return true if n == 1, otherwise false.
 *
 * Time Complexity:
 * O(log₃ n)
 * Each iteration divides n by 3.
 *
 * Space Complexity:
 * O(1)
 * No extra space is used.
 */

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        if (n <= 0) return false;

        while (n > 1) {
            if (n % 3 != 0) return false;
            n /= 3;
        }
        return n == 1;
    }
}
