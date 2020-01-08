class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount < 0) return -1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            int minPrev = Integer.MAX_VALUE;
            for (int coin : coins) {
                int prevAmount = i - coin;
                if (prevAmount >= 0) {
                    minPrev = Math.min(dp[prevAmount], minPrev);
                }
            }
            dp[i] = (minPrev != Integer.MAX_VALUE ? 1 : 0) + minPrev;
        }
        // System.out.println(Arrays.toString(dp));
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
