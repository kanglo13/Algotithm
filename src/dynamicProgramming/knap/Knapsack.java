package dynamicProgramming.knap;

public class Knapsack {
    public int knapsack(int W,int N,int[]weights,int[]values){
        int[][]dp = new int[N+1][W+1];
        for (int i = 1;i <= N;i++){
            int w = weights[i-1], v = values[i-1];
            for (int j = 1;j <= W;j++){
                if (j >= W){
                    dp[i][j] = Math.max(dp[i-1][j-w] + v,dp[i-1][j]);
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[N][W];
    }
    public int knapsackII(int W,int N,int[]weights,int[]values){
        int[]dp = new int[W+1];
        for (int i = 1;i <= N;i++){
            int w = weights[i-1],v = values[i-1];
            for (int j = W;j > 0;j--){
                if (j >= w){
                    dp[j] = Math.max(dp[j],dp[j-w]+v);
                }
            }
        }
        return dp[W];
    }
}
