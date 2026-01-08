/*
Title: Find the Single Number in an Array

Approach:
1. The array contains every element twice except for one single element.
2. Use the XOR (^) operation:
   - XOR of a number with itself is 0.
   - XOR of a number with 0 is the number itself.
3. Initialize a variable 'result' as 0.
4. Traverse the array and XOR each element with 'result'.
5. After completing the traversal, 'result' will contain the single number that appears only once.

Time Complexity: O(n)
- Single pass through the array of length n.

Space Complexity: O(1)
- No extra space is used, only a single integer variable.
*/

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i:nums){
            result ^= i;
        }
        return result;
    }
}