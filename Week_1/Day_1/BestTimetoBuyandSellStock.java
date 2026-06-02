class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int buy = prices[0];
        int maxDiff = 0;
        
        for (int i = 1; i < prices.length; i++) {
            maxDiff = Math.max(maxDiff, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }
        
        return maxDiff;
    }
}
