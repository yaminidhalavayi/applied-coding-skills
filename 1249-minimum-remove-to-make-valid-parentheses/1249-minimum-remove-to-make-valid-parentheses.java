import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();

        // Find invalid closing brackets
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '(') {
                stack.push(i);
            }

            else if (chars[i] == ')') {

                // If there is no matching '('
                if (stack.isEmpty()) {
                    chars[i] = '*'; // Mark for removal
                } 
                else {
                    stack.pop();
                }
            }
        }

        // Mark remaining invalid '(' for removal
        while (!stack.isEmpty()) {
            chars[stack.pop()] = '*';
        }

        // Build the final string
        StringBuilder result = new StringBuilder();

        for (char ch : chars) {
            if (ch != '*') {
                result.append(ch);
            }
        }

        return result.toString();
    }
}