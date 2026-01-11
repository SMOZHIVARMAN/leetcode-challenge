/*
Title: Roman to Integer

Approach:
1. Create a HashMap to store Roman numeral symbols and their integer values.
2. Initialize a variable `total` to store the final integer result.
3. Traverse the string from left to right:
   - Get the value of the current Roman character.
   - If the next character exists and its value is greater than the current value,
     subtract the current value from `total` (subtractive notation case).
   - Otherwise, add the current value to `total`.
4. After the loop ends, `total` contains the integer value of the Roman numeral.

Time Complexity: O(n)
- n is the length of the Roman numeral string.

Space Complexity: O(1)
- The HashMap contains a fixed number of Roman symbols (7),
  so it uses constant extra space.
*/

import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int current = map.get(s.charAt(i));

            if (i + 1 < n && current < map.get(s.charAt(i + 1))) {
                total -= current;
            } else {
                total += current;
            }
        }

        return total;
    }
}
