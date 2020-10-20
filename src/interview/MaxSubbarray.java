package interview;

import sun.nio.cs.ext.MacHebrew;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 11:34
 */
public class MaxSubbarray {
    public int maxSubarray(int[]nums){
        if (nums == null || nums.length == 0)
            return 0;
        int preSum = nums[0];
        int max = preSum;
        for (int i =  1;i < nums.length;i++){
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            max = Math.max(max,preSum);
        }
        return max;
    }
}
