package daily;

import java.util.Map;

public class MaxProduct {
    public int maxProduct(int[]nums){
        int len = nums.length;
        if (len == 0)
            return 0;
        int[][]dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1;i < len;i++){
            if (nums[i] >= 0){
                dp[i][0] = Math.max(nums[i],nums[i] * dp[i-1][0]);
                dp[i][1] = Math.min(nums[i],nums[i] * dp[i-1][1]);
            }
            else {
                dp[i][0] = Math.max(nums[i],nums[i]*dp[i-1][1]);
                dp[i][1] = Math.min(nums[i],nums[i]*dp[i-1][0]);
            }
        }
        int result = dp[0][0];
        for (int i = 0;i < len;i++){
            result = Math.max(result,dp[i][0]);
        }
        return result;
    }
}
