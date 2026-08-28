import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            // Collision happens only when:
            // positive asteroid is moving right
            // negative asteroid is moving left
            while (!stack.isEmpty()
                    && stack.peek() > 0
                    && asteroid < 0) {

                if (stack.peek() < -asteroid) {
                    // Top asteroid is smaller, so it explodes
                    stack.pop();
                }
                else if (stack.peek() == -asteroid) {
                    // Both asteroids explode
                    stack.pop();
                    destroyed = true;
                    break;
                }
                else {
                    // Current asteroid explodes
                    destroyed = true;
                    break;
                }
            }

            // Add asteroid if it was not destroyed
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}