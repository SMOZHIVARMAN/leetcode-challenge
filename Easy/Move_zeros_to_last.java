/*
Title: Apply Operations on Array and Move Zeros to End

Approach:
1. Traverse the array from start to second last element:
   - If two consecutive elements are equal, double the first element and set the next element to 0.
2. Create a list to store non-zero elements.
3. Add all non-zero elements from the array to the list.
4. Fill the remaining positions in the list with zeros to match the original array length.
5. Copy the elements from the list back to the array.
6. Return the modified array.

Time Complexity: 
- O(n) for first loop (checking consecutive elements)
- O(n) for collecting non-zero elements
- O(n) for adding zeros
- O(n) for copying back to array
=> Overall Time Complexity: O(n)

Space Complexity:
- O(n) for the auxiliary list storing non-zero elements and zeros
=> Overall Space Complexity: O(n)
*/

class Solution {
    public int[] applyOperations(int[] arr) {
        List<Integer>ls= new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
          if(arr[i]==arr[i+1]){
            arr[i]*=2;
            arr[i+1]=0;
          }
        }
        for(int i:arr){
            if(i!=0){
                ls.add(i);
            }
        }
        for(int i=0;i<=arr.length;i++){
            ls.add(0);
        }
        for(int i=0;i<arr.length;i++){
            arr[i]= ls.get(i);
        }
        return arr;
    }
}