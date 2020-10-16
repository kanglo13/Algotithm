package interview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/16 14:37
 */
public class ThreeSumII {
    public List<List<Integer>>threeSum(int[]nums){
        List<List<Integer>>result = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return result;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0;i < n;i++){
            if (nums[i] > 0)
                break;
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            int left = i + 1, right = n-1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left+1])
                        left++;
                    while (left < right && nums[right] == nums[right-1])
                        right--;
                    left++;
                    right--;
                }
                else if (sum < 0)
                    left++;
                else
                    right--;
            }
        }
        return result;
    }
}
