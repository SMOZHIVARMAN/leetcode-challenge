/*
Title: Add Binary Strings

Approach:
1. Use two pointers to traverse both binary strings from right to left.
2. Maintain a `carry` variable to store carry-over during binary addition.
3. Repeat while:
   - There are digits left in either string, or
   - There is a remaining carry.
4. In each iteration:
   - Start with the carry value.
   - Add the current digit from string `a` if available.
   - Add the current digit from string `b` if available.
   - Append (sum % 2) to the result (current binary digit).
   - Update carry as (sum / 2).
5. Reverse the result string since digits are added from least significant to most significant.
6. Return the final binary string.

Time Complexity: O(max(n, m))
- Where n and m are the lengths of strings `a` and `b`.

Space Complexity: O(max(n, m))
- Space used by StringBuilder to store the result.
*/

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            if (i >= 0) sum += a.charAt(i--) - '0';  
            if (j >= 0) sum += b.charAt(j--) - '0';
            
            result.append(sum % 2);  
            carry = sum / 2;         
        }
        
        return result.reverse().toString();
    }
}