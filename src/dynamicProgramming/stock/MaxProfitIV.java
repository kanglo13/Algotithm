package dynamicProgramming.stock;

public class MaxProfitIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k <= 0)
            return 0;
        int n = prices.length;
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1;i < n;i++){
                if (prices[i] > prices[i-1])
                    maxProfit += prices[i] - prices[i-1];
            }
            return maxProfit;
        }
            int[][][] dp = new int[n][k + 1][2];
            for (int i = 0; i < n; i++) {
                for (int j = k; j >= 1; j--) {
                    if (i - 1 == -1) {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[i];
                        continue;
                    }
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
            return dp[n - 1][k][0];
        }
    }

