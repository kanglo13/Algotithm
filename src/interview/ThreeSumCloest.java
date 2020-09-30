package interview;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2020-09-2020/9/30 20:42
 */
public class ThreeSumCloest {
    public int threeSumCloeset(int[]nums,int target){
        Arrays.sort(nums);
        int len = nums.length;
        int result = nums[1] + nums[2] + nums[3];
        for (int i = 0;i < len;i++){
            if (nums[i] >= target)
                break;
            int left = i + 1;
            int right = len -1;
            while (left < right){
                int sum = nums[left] + nums[i] + nums[right];
                if (Math.abs(sum-target) < Math.abs(result-target))
                    result = sum;
                if (sum > target)
                    right--;
                else if (sum < target)
                    left++;
                else
                    return result;
            }
        }
        return result;
    }
}
