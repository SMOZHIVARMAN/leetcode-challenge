/*Title: Two Sum using Brute Force Approach
----------------------------------------
Problem: Find two indices in the array such that their values add up to the target.

Approach:
1. Create an integer array of size 2 to store the result indices.
2. Use two nested loops to check every possible pair of elements.
3. For each pair (nums[i], nums[j]), check if their sum equals the target.
4. If a matching pair is found, store their indices and return the result.
5. If no pair is found, return the default array.

Time Complexity: O(n^2)
- Due to the nested loops iterating over the array.

Space Complexity: O(1)
- Uses a constant amount of extra space (fixed-size array).*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ar[] = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    
                    ar[0] = i;
                    ar[1] = j;
                    return ar;
                }
            }
        }
        return ar;
    }
    
}