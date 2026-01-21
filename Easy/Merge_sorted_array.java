/*
Title: Merge Sorted Array

Approach:
1. Since nums1 has enough extra space at the end, merge from the back to avoid overwriting elements.
2. Use three pointers:
   - i = m - 1 → last valid element in nums1
   - j = n - 1 → last element in nums2
   - k = m + n - 1 → last position in nums1 (final merged array)
3. While both arrays still have elements:
   - Compare nums1[i] and nums2[j]
   - Place the larger element at nums1[k]
   - Move the corresponding pointers backward
4. If nums2 still has remaining elements, copy them into nums1.
   (If nums1 has remaining elements, they are already in correct position.)

Time Complexity: O(m + n)
- Each element from nums1 and nums2 is processed once.

Space Complexity: O(1)
- Merging is done in-place without extra arrays.
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
