/*
Title: Reverse a Character Array (In-Place)

Approach:
1. Use a two-pointer technique.
2. Initialize:
   - `left` pointer at the beginning of the array.
   - `right` pointer at the end of the array.
3. While left < right:
   - Swap the characters at positions `left` and `right`.
   - Move `left` forward and `right` backward.
4. Continue until the pointers meet or cross.
5. The array is reversed in-place without using extra space.

Time Complexity: O(n)
- n is the length of the character array.

Space Complexity: O(1)
- Reversal is done in-place using constant extra space.
*/

class Solution {
    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
