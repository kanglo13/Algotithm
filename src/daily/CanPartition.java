package daily;

/**
 * @author kanglo
 * @create 2020-10-2020/10/11 9:46
 */
public class CanPartition {
    public boolean canPartition(int[]nums){
        if (nums == null || nums.length == 0)
            return false;
        int sum = getSum(nums);
        if (sum % 2 != 0)
            return false;
        int n = sum / 2;
        boolean[]dp = new boolean[n+1];
        dp[0] = true;
        for (int num : nums){
            for (int i = n ;i >= num;i--){
                dp[i] |= dp[i-num];
            }
        }
        return dp[n];
    }
    private int getSum(int[]nums){
        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum;
    }
    public boolean canPartitionKSubsets(int[]nums,int k){
        if (nums == null || nums.length == 0)
            return false;
        int sum = 0, maxNum = 0;
        for (int num : nums){
            sum += num;
            if (num > maxNum)
                maxNum = num;
        }
        if (sum % k != 0 || maxNum > sum / k)
            return false;
        return backtracking(nums,new boolean[nums.length],sum/k,k,0,0);

    }
    private boolean backtracking(int[]nums,boolean[]hasVisited,int target,int k,int curSum,int start){
        if (k == 0)
            return true;
        if (curSum == target){
            return backtracking(nums,hasVisited,target,k-1,0,0);
        }
        for (int i = start;i < nums.length;i++){
            if (!hasVisited[i] && curSum+nums[i] <= target){
                hasVisited[i] = true;
                if (backtracking(nums,hasVisited,target,k,curSum+nums[i],i+1))
                    return true;
                hasVisited[i] = false;
            }
        }
        return false;
    }
}
