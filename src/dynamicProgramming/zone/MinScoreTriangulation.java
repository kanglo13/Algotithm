package dynamicProgramming.zone;

public class MinScoreTriangulation {
    public int minScoreTriangulation(int[]A){
        if (A == null || A.length == 0)
            return 0;
        int n = A.length;
        int[][]dp = new int[n][n];
        for (int len = 3;len <= n;len++){
            for (int left = 0;left <= n -len;left++){
                int right = left + len - 1;
                dp[left][right] = Integer.MAX_VALUE;
                for (int i = left + 1;i <= right;i++){
                    dp[left][right] = Math.min(dp[left][right],dp[left][i]+dp[i][right]+A[left]*A[i]*A[right]);
                }
            }
        }
        return dp[0][n-1];
    }
}
