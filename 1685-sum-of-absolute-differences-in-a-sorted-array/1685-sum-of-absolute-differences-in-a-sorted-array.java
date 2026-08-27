class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];
        
        // Find total sum
        int totalSum = 0;
        
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        
        for (int i = 0; i < n; i++) {
            
            // Sum of differences with elements on the left
            int leftDifference = nums[i] * i - leftSum;
            
            // Sum of differences with elements on the right
            int rightDifference =
                    (totalSum - leftSum - nums[i])
                    - nums[i] * (n - i - 1);
            
            result[i] = leftDifference + rightDifference;
            
            // Add current element to left sum
            leftSum += nums[i];
        }
        
        return result;
    }
}