/*
Title: Vowel-Consonant Score

Approach:
1. Initialize two counters:
   - vowels   → counts vowel characters in the string
   - consonants → counts consonant characters in the string
2. Traverse each character in the string:
   - If the character is a vowel (A, E, I, O, U in both upper/lower case),
     increment vowels.
   - Else if the character is an alphabet letter, increment consonants.
   - Ignore non-letter characters (digits, spaces, symbols).
3. If consonants count is 0, return 0 to avoid division by zero.
4. Otherwise, return vowels / consonants (integer division).

Time Complexity: O(n)
- n is the length of the string; each character is processed once.

Space Complexity: O(1)
- Uses only constant extra variables.
*/

class Solution {
    public int vowelConsonantScore(String s) {
        int vowels = 0, consonants = 0;

        for (char ch : s.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                vowels++;
            } else if (Character.isLetter(ch)) {
                consonants++;
            }
        }

        return consonants == 0 ? 0 : vowels / consonants;
    }
}
