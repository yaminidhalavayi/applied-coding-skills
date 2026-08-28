import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Find next greater element for every number in nums2
        for (int num : nums2) {

            // If current number is greater than stack top,
            // it is the next greater element
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        // Create answer for nums1
        int[] answer = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            answer[i] = map.getOrDefault(nums1[i], -1);
        }

        return answer;
    }
}