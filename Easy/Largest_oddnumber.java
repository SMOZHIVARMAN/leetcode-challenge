/*
Title: Largest Odd Number in a String

Approach:
1. We need to find the largest-valued odd number that can be formed by taking
   a prefix of the given numeric string.
2. An integer is odd if its last digit is odd (1, 3, 5, 7, 9).
3. Traverse the string from the last index to the first:
   - Convert the current character to its digit value.
   - If the digit is odd, return the substring from index 0 to i (inclusive).
4. If no odd digit is found, return an empty string.

Time Complexity: O(n)
- In the worst case, we scan all digits once.

Space Complexity: O(1)
- No extra space is used apart from the returned substring.
*/

class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            if (digit % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
