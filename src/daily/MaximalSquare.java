package daily;

public class MaximalSquare {
    public int maximalSquare(char[][]matrix){
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return 0;
        int m = matrix.length , n = matrix[0].length;
        int maxEdge = 0;
        int[][]dp = new int[m+1][n+1];

        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (matrix[i][j] == '1'){
                    dp[i+1][j+1] = Math.min(dp[i][j+1],Math.min(dp[i+1][j],dp[i][j])) + 1;
                    maxEdge = Math.max(maxEdge,dp[i+1][j+1]);
                }
            }
        }
        return maxEdge * maxEdge;
    }
}
