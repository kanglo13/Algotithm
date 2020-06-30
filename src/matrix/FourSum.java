package matrix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[]nums, int target){
        List<List<Integer>>result = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return result;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0;i < len - 3;i++){
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            int min1 = nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            int max1 = nums[len-1] + nums[len-2] + nums[len-3] + nums[i];
            if (min1 > target || max1 < target)
                continue;
            for (int j = i + 1;j < len -2;j++){
                if (j != i+1 && nums[j] == nums[j-1])
                    continue;
                int l = j + 1, r = len - 1;
                int min2 = nums[i] + nums[j] + nums[l] + nums[l+1];
                int max2 = nums[i] + nums[j] + nums[r] + nums[r-1];
                if (min2 > target || max2 < target)
                    continue;
                while (l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while (l < r && nums[l] == nums[l+1])
                            l++;
                        while (l < r && nums[r] == nums[r-1])
                            r--;
                        l++;
                        r--;
                    }
                    else if (sum < target)
                        l++;
                    else
                        r--;
                }
            }
        }
        return result;
    }
}
