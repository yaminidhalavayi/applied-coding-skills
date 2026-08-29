import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {

        // Convert integers to strings
        String[] arr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Sort to form the largest number
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // If the largest element is "0", all numbers are zero
        if (arr[0].equals("0")) {
            return "0";
        }

        // Combine all numbers
        StringBuilder result = new StringBuilder();

        for (String num : arr) {
            result.append(num);
        }

        return result.toString();
    }
}