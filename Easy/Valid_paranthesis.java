/*
Title: Valid Parentheses

Approach:
1. Use a stack to check for matching parentheses.
2. Traverse each character in the string:
   - If it is an opening bracket '(', '{', or '[', push it onto the stack.
   - If it is a closing bracket ')', '}', or ']', check the top of the stack:
       a) If the stack is empty, return false (no matching opening bracket)
       b) Pop the top element and check if it matches the corresponding opening bracket.
          - If it does not match, return false.
3. After processing all characters, if the stack is empty, all brackets were matched; return true.
   Otherwise, return false.

Time Complexity: O(n)
- n is the length of the string; each character is pushed and popped at most once.

Space Complexity: O(n)
- In the worst case, all characters are opening brackets and stored in the stack.
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ;i< s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.isEmpty()) return false;
                char top = st.pop();

            if(ch == ')' && top != '(')
            {
                return false;
            }
            
            if(ch == '}' && top != '{')
            {
                return false;
            }

            if(ch == ']' && top != '[')
            {
                return false;
            }
            

            }

            

        }
        return st.isEmpty();
    }
    
}