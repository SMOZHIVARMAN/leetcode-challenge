/*
Title: Find the Missing Number in an Array

Approach:
1. The array contains n distinct numbers taken from 0 to n, with exactly one number missing.
2. Calculate the expected sum of numbers from 0 to n using the formula: n * (n + 1) / 2
3. Calculate the actual sum of all elements in the array by iterating through it.
4. The missing number is the difference between the expected sum and the actual sum.

Time Complexity: O(n)
- One pass through the array to calculate the actual sum.

Space Complexity: O(1)
- No extra space is used, only integer variables for sums and array length.
*/

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedsum = (n * (n + 1) / 2);
        int actualsum = 0;
        for(int a:nums){
            actualsum += a;
        }
        return expectedsum - actualsum;
    }
} 