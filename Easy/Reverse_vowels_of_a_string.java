/*
Title: Reverse Vowels of a String

Approach:
1. Convert the string into a character array so it can be modified in-place.
2. Use two pointers:
   - i starting from the beginning
   - j starting from the end
3. Move pointer i forward until it points to a vowel.
4. Move pointer j backward until it points to a vowel.
5. Swap the vowels at positions i and j.
6. Continue this process until i >= j.
7. Convert the modified character array back into a string and return it.

Helper Function (isVovel):
- Checks if a character is a vowel by searching it in the string "aeiouAEIOU".

Time Complexity: O(n)
- Each character is visited at most once by the two pointers.

Space Complexity: O(n)
- A character array is created from the input string (extra space).
*/

class Solution {
    public String reverseVowels(String s) {
        char[] sarray = s.toCharArray();
        int i = 0;
        int j = sarray.length - 1;

        while (i < j) {

            while (i < j && !isVovel(sarray[i])) {
                i++;
            }

            while (i < j && !isVovel(sarray[j])) {
                j--;
            }

            char temp = sarray[i];
            sarray[i] = sarray[j];
            sarray[j] = temp;
            i++;
            j--;
        }

        return new String(sarray);
    }

    boolean isVovel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
