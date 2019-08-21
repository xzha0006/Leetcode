class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int buy = 0;
        for (int i = 0; i < prices.length; ++i) {
            res = Math.max(res, prices[i] - prices[buy]);
            if (prices[i] < prices[buy]) {
                buy = i;
            } 
        }
        return res;
    }
}
