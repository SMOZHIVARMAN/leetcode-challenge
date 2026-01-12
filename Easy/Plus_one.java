/*
Title: Plus One

Approach:
1. Start from the last digit (least significant digit).
2. If the current digit is less than 9:
   - Increment it by 1.
   - Return the updated array immediately (no carry needed).
3. If the digit is 9:
   - Set it to 0 and continue to the next digit (carry propagation).
4. If all digits are 9:
   - Create a new array of size n + 1.
   - Set the first digit to 1 and the rest remain 0.
5. Return the resulting array.

Time Complexity: O(n)
- In the worst case, all digits are 9 and we traverse the entire array.

Space Complexity: O(n)
- Only in the case where all digits are 9, a new array is created.
- Otherwise, space complexity is O(1).
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
