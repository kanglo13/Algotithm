package dynamicProgramming.subsequence;

import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle){
        if (triangle == null || triangle.size() == 0)
            return 0;
        int r = triangle.size();
        int c = triangle.get(r-1).size();
        int [][] dp = new int[r][c];
        dp[0][0] = triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;
        for (int i = 1;i < r;i++){
            for (int j = 0;j <= i;j++){
                if (j == 0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }
                else if (j == i){
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }
        for (int i = 0;i < c;i++){
            res = Math.min(res,dp[r-1][i]);
        }
        return res;
    }
}
