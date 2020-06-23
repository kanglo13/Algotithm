package sorting;

import List.ListNode;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public List<Integer>findDisappearedNumbers(int[]nums){
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        int len = nums.length;
        for (int i = 0;i < len;i++){
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i]-1] != nums[i])
                swap(nums,nums[i]-1,i);
        }
        for (int i = 0;i < len;i++){
            if (nums[i] != i+1)
                res.add(i+1);
        }
        return res;
    }
    private void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
