package interview;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2020-10-2020/10/6 20:23
 */
public class CoinChange {
    public int coinChange(int[]coins,int amount){
        int[]dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int coin : coins){
            for (int i = coin;i <= amount;i++){
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
    public int change(int amount,int[] coins){
        int[]dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins){
            for (int i = coin;i <= amount;i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
