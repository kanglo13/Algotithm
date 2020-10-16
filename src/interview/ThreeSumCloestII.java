package interview;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2020-10-2020/10/16 14:55
 */
public class ThreeSumCloestII {
    public int ThreeSumCloest(int[]nums,int target){
        int n = nums.length;
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0;i < n;i++){
            int left = i + 1, right = n - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target)
                    return sum;
                if (Math.abs(result-target) >Math.abs(sum-target))
                    result = sum;
                else {
                    if (sum < target)
                        left++;
                    else
                        right--;
                }
            }
        }
        return result;
    }
}
