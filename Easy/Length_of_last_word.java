/*
Title: Length of Last Word in a String

Approach:
1. Split the input string using space `" "` as the delimiter.
2. Store the resulting substrings (words) in an array.
3. The last element of the array represents the last word in the string.
4. Return the length of the last word.

Time Complexity: O(n)
- n is the length of the string; splitting the string requires traversing it.

Space Complexity: O(n)
- Additional space is used to store the array of words created by split().
*/

class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        int len = words.length;
        String last = words[len-1];
        return (last.length());
    }
}