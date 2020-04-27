package dynamicProgramming.coinChange;

public class Change {
    public int change(int[]coins,int amount){
        if (coins == null || coins.length == 0)
            return 0;
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
