/*
Title: Add Digits (Repeated Digit Sum)

Approach:
1. Keep reducing the number until it becomes a single digit.
2. While num has more than one digit (num >= 10):
   - Initialize sum = 0
   - Extract each digit using num % 10 and add it to sum
   - Remove the last digit using num /= 10
   - Assign num = sum after finishing the digit sum
3. When num becomes a single digit, return it.

Time Complexity:
- O(log num) per digit-sum operation, and it may repeat a few times.
- Overall time is small and effectively constant for integer constraints.

Space Complexity:
- O(1)
- Uses only constant extra variables.
*/

class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            num = sum;
        }

        return num;
    }
}
