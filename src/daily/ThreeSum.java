package daily;

import javax.print.attribute.standard.RequestingUserName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[]nums){
        List<List<Integer>>result = new ArrayList<>();
        int len = nums.length;
        if (len < 3)
            return result;
        Arrays.sort(nums);
        for (int i = 0;i < len;i++){
            if (nums[i] > 0)
                break;
            int L = i + 1;
            int R = len - 1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L < R && nums[L] == nums[L+1])
                        L++;
                    while (L < R && nums[R] == nums[R-1])
                        R--;
                }
                else if (sum < 0)
                    L++;
                else
                    R--;

            }
        }
        return result;
    }
}
