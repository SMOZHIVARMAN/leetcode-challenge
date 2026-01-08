/*
Title: Check if an Integer is a Palindrome

Approach:
1. If the number is negative, it cannot be a palindrome. Return false.
2. Store the original number in a variable 'original' for later comparison.
3. Initialize 'temp' as 0 to build the reversed number.
4. Reverse the number:
   - While x is not 0:
       a) Multiply temp by 10 and add the last digit of x (x % 10)
       b) Remove the last digit from x (x /= 10)
5. Compare the reversed number (temp) with the original number:
   - If equal, return true (it's a palindrome)
   - Otherwise, return false

Time Complexity: O(log10(x))
- Each iteration removes one digit from x, so the number of iterations is proportional to the number of digits.

Space Complexity: O(1)
- Only a few integer variables are used; no extra space proportional to input is needed.
*/

class Solution {
    public boolean isPalindrome(int x) {
        int original = x;
        int temp = 0;
        if (x < 0) return false;
        while(x != 0){
            temp *= 10;
            temp += x % 10;
            x /= 10;
        }
        if(original == temp){
            return true;
        }
        else{
            return false;
        }
    }
}