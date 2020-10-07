package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/5 15:34
 */
public class MaxSubArray {
    public int maxSubArray(int[]nums){
        if (nums == null || nums.length == 0)
            return 0;
        int preSum = nums[0];
        int maxSum = 0;
        for (int i = 1;i < nums.length;i++){
            preSum = preSum < 0 ? nums[i] : preSum + nums[i];
            maxSum = Math.max(preSum,maxSum);
        }
        return maxSum;
    }
}
