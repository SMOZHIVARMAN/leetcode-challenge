/*
Title: Valid Palindrome

Approach:
1. Use two pointers:
   - `left` starting from the beginning of the string.
   - `right` starting from the end of the string.
2. Move the `left` pointer forward until it points to an alphanumeric character.
3. Move the `right` pointer backward until it points to an alphanumeric character.
4. Compare the characters at `left` and `right` after converting them to lowercase.
   - If they are not equal, return false.
5. Move both pointers inward and repeat the process.
6. If all valid character pairs match, return true.

Time Complexity: O(n)
- n is the length of the string; each character is visited at most once.

Space Complexity: O(1)
- No extra space is used; comparisons are done in-place.

Note:
- This approach ignores non-alphanumeric characters and is case-insensitive,
  as required by the problem.
*/

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        return true;
    }
}
