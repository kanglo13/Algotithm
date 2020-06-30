package dynamicProgramming.matrix;

public class MaxmalSquare {
    public int maximalSquare(int[][]matrix){
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return 0;
        int r = matrix.length, c = matrix[0].length;
        int[][]dp = new int[r+1][c+1];
        int maxSide = 0;
        for (int i = 0;i < r;i++){
            for (int j = 0;j < c;j++){
                if (matrix[i][j] == 1){
                    dp[i+1][j+1] = Math.min(dp[i][j],Math.min(dp[i+1][j],dp[i][j+1])) + 1;
                    maxSide = Math.max(maxSide,dp[i+1][j+1]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
