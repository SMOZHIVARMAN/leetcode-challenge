/*
Title: Find Maximum Consecutive Ones in a Binary Array

Approach:
1. Initialize two variables:
   - maxstreak: to store the maximum consecutive 1's found so far.
   - current: to count the current streak of consecutive 1's.
2. Traverse the array:
   - If the current element is 1, increment current and update maxstreak if current > maxstreak.
   - If the current element is 0, reset current to 0.
3. After traversing the array, maxstreak contains the maximum number of consecutive 1's.

Time Complexity: O(n)
- Single pass through the array of length n.

Space Complexity: O(1)
- Only two integer variables are used, no extra space proportional to input.
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxstreak = 0;
        int current = 0;
        for(int n:nums){
            if(n == 1){
                current++;
                maxstreak = Math.max(current,maxstreak);
            }
            else{
                current = 0;
            }
        }
        return maxstreak;
    }
}