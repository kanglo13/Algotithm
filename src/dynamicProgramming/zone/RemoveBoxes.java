package dynamicProgramming.zone;

public class RemoveBoxes {
   private int dp[][][];
   private int[]boxes;
   public int removeBoxes(int[]boxes){
       int n = boxes.length;
       dp = new int[n][n][n];
       this.boxes = boxes;
       return dfs(0,n-1,0);
   }
   private int dfs(int i,int j,int k){
       if (i > j)
           return 0;
       if (dp[i][j][k] > 0)
           return dp[i][j][k];
       while (i < j && boxes[i] == boxes[i+1]){
           i++;
           k++;
       }
       int res = (k+1) * (k + 1) + dfs(i+1,j,0);
       for (int m = i+1;m <= j;m++){
           if (boxes[m] == boxes[i])
               res = Math.max(res,dfs(i+1,m-1,0)+dfs(m,j,k+1));
       }
       return dp[i][j][k] = res;
   }
}
