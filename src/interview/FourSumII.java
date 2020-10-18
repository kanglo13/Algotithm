package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/16 15:54
 */
public class FourSumII {
    public List<List<Integer>>fourSum(int[]nums,int target){
        List<List<Integer>>result = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return result;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0;i < n-3;i++){
            int min1 = nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            int max1 = nums[i] + nums[n-1] + nums[n-2] + nums[n-3];
            if (max1 < target || min1 > target)
                continue;
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i + 1;j < n - 2;j++){
                int min2 = nums[i] + nums[j] + nums[j+1] + nums[j+2];
                int max2 = nums[i] + nums[j] + nums[n-1] + nums[n-2];
                if (min2 > target || max2 < target)
                    continue;
                if (j != i+1 && nums[j] == nums[j-1])
                    continue;
                int left = j + 1, right = n - 1;
                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left < right && nums[left] == nums[left+1])left++;
                        while (left < right && nums[right] == nums[right-1])right--;
                        left++;
                        right--;
                    }
                    else if (sum < target)
                        left++;
                    else
                        right--;
                }
            }
        }
        return result;
    }
}
