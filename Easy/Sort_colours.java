/*
Title: Sort Colors (Sort an Array with 0, 1, 2)

Approach:
1. The given code uses Bubble Sort to sort the array in ascending order.
   - Compare each element with its next element.
   - Swap if the next element is smaller.
   - Repeat for all elements until the array is sorted.
2. After sorting, the array elements are printed (though in LeetCode style problems, printing is not needed).
3. This approach works but is not optimal for the "Sort Colors" problem, which can be done in one pass using the Dutch National Flag algorithm.

Time Complexity:
- Bubble Sort: O(n^2) in worst case
- Where n is the length of the array

Space Complexity:
- O(1), in-place sorting (no extra space used)

Optimal Approach (Dutch National Flag Algorithm):
- Use three pointers: low, mid, high
- Swap 0s to the beginning, 2s to the end, and 1s remain in the middle
- Time Complexity: O(n)
- Space Complexity: O(1)
*/
class Solution {
    public void sortColors(int[] nums) {
        int length = nums.length;
        for(int i = 0;i < length; i++)
        {
            for(int j = 0;j < length -i -1 ;j++)
            {
                if(nums[j+1]<nums[j])
                {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
            System.out.print(nums[i]+" ");
        }
    }
}