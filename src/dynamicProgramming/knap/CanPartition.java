package dynamicProgramming.knap;

public class CanPartition {
    public boolean canPartition(int[]nums){
        int sum = computeSum(nums);
        if (sum % 2 != 0)
            return false;
        int W = sum % 2;
        boolean[]dp = new boolean[W+1];
        for (int num : nums){
            for (int i = W;i >= num;i--){
                dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[W];
    }
    private int computeSum(int[]nums){
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        return sum;
    }
}
