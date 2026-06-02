class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double currentSum = 0;
        
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        double bestSum = currentSum;
        
        int right = k;
        while (right < nums.length) {
            currentSum += nums[right] - nums[right - k];
            if (currentSum > bestSum) {
                bestSum = currentSum;
            }
            right++;
        }
        
        return bestSum / k;
    }
}
