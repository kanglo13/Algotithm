package daily;

/**
 * @author kanglo
 * @create 2021-03-2021/3/1 10:55
 */
public class NumArray {
    private int[] preSum;
    public NumArray(int[]nums){
        preSum = new int[nums.length];
        if (nums.length == 0)
            return;
        preSum[0] = nums[0];
        for (int i = 1;i < nums.length;i++){
            preSum[i] = preSum[i-1] + nums[i];
        }

    }
    public int sumRange(int i,int j){
        if (i == 0)
            return preSum[j];
        return preSum[j] - preSum[i-1];
    }
}
