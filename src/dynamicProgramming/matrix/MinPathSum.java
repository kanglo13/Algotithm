package dynamicProgramming.matrix;

public class MinPathSum {
    public int minPathSum(int[][]grid){
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1;i < m;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1;j < n;j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
    public int minPathSumII(int[][]grid){
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[]dp = new int[n];

        for (int i = 0;i < m; i++){
            for (int j = 0;j < n; j++){
                if (j == 0)
                    dp[j] = dp[j];
                else if(i == 0)
                    dp[j] = dp[j-1];
                else
                    dp[j] = Math.min(dp[j-1],dp[j]);
                dp[j] += grid[i][j];
            }
        }
        return dp[n-1];

    }
}
