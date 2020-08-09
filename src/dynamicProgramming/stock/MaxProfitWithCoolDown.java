package dynamicProgramming.stock;


public class MaxProfitWithCoolDown {
    public int maxProfit(int[] prices){
        if (prices == null || prices.length == 0)
            return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0;i < n;i++){
            if (i - 1 == -1){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            if (i - 2 == -1){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
