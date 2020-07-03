package dynamicProgramming.search;

public class LongestIncreasingPath {
    private int m;
    private int n;
    private int[][]direction = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][]matrix){
        if (matrix == null || matrix.length == 0)
            return 0;
        m = matrix.length;
        n = matrix[0].length;
        int maxLen = 0;
        int[][]dp = new int[m][n];
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                maxLen = Math.max(maxLen,dfs(matrix,dp,i,j));
            }
        }
        return maxLen;
    }
    private int dfs(int[][]matrix,int[][]dp,int r,int c){
        if (dp[r][c] != 0)
            return dp[r][c];

        for (int[]d :direction){
            if (valid(r+d[0],c+d[1]) && matrix[r][c] < matrix[r+d[0]][c+d[1]]){
                dp[r][c] = Math.max(dp[r][c],dfs(matrix,dp,r+d[0],c+d[1]));
            }
        }
        return ++dp[r][c];
    }
    private boolean valid(int r,int c){
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
