package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/5 9:12
 */
public class FourSum {
    public List<List<Integer>>fourSum(int[]nums,int target){
        List<List<Integer>>result = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return result;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0;i < len-3;i++){
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            int max1 = nums[i] + nums[len-1] + nums[len-2] + nums[len-3];
            int min1 = nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            if (min1 > target || max1 < target)
                continue;
            for (int j = i + 1;j < len-2;j++){
                if (j != i + 1 && nums[j] == nums[j-1])
                    continue;
                int left = j + 1;
                int right = len - 1;
                int max2 = nums[i] + nums[j] + nums[right] + nums[right-1];
                int min2 = nums[i] + nums[j] + nums[left] + nums[left+1];
                if (max2 < target || min2 > target)
                    continue;
                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left < right && nums[left] == nums[left+1])
                            left++;
                        while (left < right && nums[right] == nums[right-1])
                            right--;
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
