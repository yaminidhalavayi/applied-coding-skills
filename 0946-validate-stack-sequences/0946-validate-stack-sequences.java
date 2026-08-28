import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int j = 0;

        // Push each element
        for (int num : pushed) {
            stack.push(num);

            // Pop while the top matches popped[j]
            while (!stack.isEmpty()
                    && j < popped.length
                    && stack.peek() == popped[j]) {

                stack.pop();
                j++;
            }
        }

        // If all elements were popped correctly
        return j == popped.length;
    }
}