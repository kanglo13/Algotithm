package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-02-2021/2/13 11:04
 */
public class FindDisappearedNumbers {
    public List<Integer>findDisappearedNumbers(int[]nums){
        List<Integer>result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        int len = nums.length;
        for (int i = 0;i < len;i++){
            while (nums[i] > 0 && nums[i] < len && nums[nums[i]-1] != nums[i])
                swap(nums,nums[i]-1,i);
        }
        for (int i = 0;i < len;i++){
            if (nums[i] != i+1)
                result.add(i+1);
        }
        return result;
    }
    private void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
