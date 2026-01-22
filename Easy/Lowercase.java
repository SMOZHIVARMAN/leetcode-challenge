/*
Title: Convert String to Lowercase

Approach:
1. Use Java’s built-in `toLowerCase()` method to convert all uppercase
   characters in the string to lowercase.
2. Return the converted string.

Time Complexity: O(n)
- n is the length of the string; each character is processed once.

Space Complexity: O(n)
- A new lowercase string is created (strings are immutable in Java).
*/

class Solution {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}
