package interview;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author kanglo
 * @create 2020-10-2020/10/1 15:55
 */
public class MinimumOperations {
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        int[][]dp = new int[n][3];
        for (int[]vals : dp)
            Arrays.fill(vals,Integer.MAX_VALUE);
        dp[0][0] = (leaves.charAt(0) == 'y' ? 1 : 0);
        for (int i = 1;i < n;i++){
            dp[i][0] = dp[i-1][0] + (leaves.charAt(i) == 'y' ? 1 : 0);
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]) + (leaves.charAt(i) == 'r' ? 1 : 0);
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][2]) + (leaves.charAt(i) == 'y' ? 1 : 0);
        }
        return dp[n-1][2];
    }
}
