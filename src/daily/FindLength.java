package daily;

public class FindLength {
    public int findLength(int[]A,int[]B){
       int m = A.length, n = B.length;
       int[][]dp = new int[m+1][n+1];
       int maxLen = 0;
       for (int i = 1;i <= m;i++){
           for (int j = 1;j <= n;j++){
               if (A[i-1] == B[j-1])
                   dp[i][j] = dp[i-1][j-1] + 1;
               else
                   dp[i][j] = 0;
               maxLen = Math.max(maxLen,dp[i][j]);
           }
       }
       return maxLen;
    }
}
