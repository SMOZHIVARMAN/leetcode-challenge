/*
Title: Reverse Integer

Approach:
1. Initialize a variable `result` as long to safely store the reversed value
   without overflow during calculation.
2. Extract digits from the number one by one:
   - Get the last digit using x % 10
   - Append it to result using: result = result * 10 + digit
   - Remove the last digit from x using: x /= 10
3. Before updating result, check for overflow:
   - If result is already greater than Integer.MAX_VALUE / 10
     or less than Integer.MIN_VALUE / 10, return 0 immediately.
4. After finishing the loop, check if result is still within 32-bit integer range.
5. If it exceeds range, return 0, else return result as int.

Time Complexity: O(log10(x))
- The loop runs once per digit in x.

Space Complexity: O(1)
- Uses only constant extra space.
*/

class Solution {
    public int reverse(int x) {
        long result = 0;

        while (x != 0) {

            // Overflow check before multiplying result by 10
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }

            result = result * 10 + x % 10;
            x /= 10;
        }

        return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int) result;
    }
}
