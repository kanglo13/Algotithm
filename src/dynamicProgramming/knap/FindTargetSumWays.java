package dynamicProgramming.knap;

public class FindTargetSumWays {
    public int findTargetSumWays(int[]nums,int S){
        int sum = computeSum(nums);
        if ((sum + S) % 2 != 0 || sum < S)
            return 0;
        int W = (sum + S) / 2;
        int[]dp = new int[W+1];
        dp[0] = 1;
        for (int num : nums){
            for (int i = W;i >= num;i--){
                dp[i] += dp[i-num];
            }
        }
        return dp[W];
    }
    private int computeSum(int[]nums){
        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum;
    }
}
