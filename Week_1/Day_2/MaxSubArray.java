class Solution {
    public int maxSubArray(int[] nums) {
        int highest = nums[0];
        int runningSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            
            if (runningSum > highest) {
                highest = runningSum;
            }
            
            if (runningSum < 0) {
                runningSum = 0;
            }
        }
        
        return highest;
    }
}
