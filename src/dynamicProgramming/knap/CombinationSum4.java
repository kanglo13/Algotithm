package dynamicProgramming.knap;

import java.util.Arrays;

public class CombinationSum4 {
    public int combinationSum4(int[]nums,int target){
        if(nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int[]dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1;i <= target;i++){
            for (int j = 0;j < nums.length && nums[j] <= i;j++){
                dp[i] += dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}
