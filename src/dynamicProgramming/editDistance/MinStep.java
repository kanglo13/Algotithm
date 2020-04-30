package dynamicProgramming.editDistance;

public class MinStep {
    public int minStep(int n){
        int[]dp = new int[n+1];
        int h = (int)Math.sqrt(n);
        for (int i = 2;i <= n;i++){
            dp[i] = i;
            for(int j = 2;j <= i;j++){
                if (i % j == 0){
                    dp[i] = dp[j] + dp[i/j];
                    break;
                }
            }
        }
        return dp[n];
    }
}
