class Solution:
    def maxProfit(self, prices):
        """
        BF solution is O(n^2)
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        minPrice = prices[0]
        maxProfit = 0
        for price in prices:
            minPrice = min(minPrice, price)          
            profit = price - minPrice
            maxProfit = max(profit, maxProfit)
        return maxProfit
