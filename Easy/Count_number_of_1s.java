/*
Title: Number of 1 Bits (Hamming Weight)

Approach:
1. Convert the integer `n` into its binary string representation using:
   Integer.toBinaryString(n)
2. Traverse through the binary string character by character.
3. Count how many characters are equal to '1'.
4. Return the count.

Time Complexity: O(32) ≈ O(1)
- An integer contains at most 32 bits, so the binary string length is at most 32.

Space Complexity: O(32) ≈ O(1)
- Extra space is used for storing the binary string representation.
*/

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        String binary = Integer.toBinaryString(n);

        for (int i = 0; i < binary.length(); i++) {
            char ch = binary.charAt(i);
            if (ch == '1') {
                count++;
            }
        }
        return count;
    }
}
