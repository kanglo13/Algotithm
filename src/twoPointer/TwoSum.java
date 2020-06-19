package twoPointer;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[]twoSum(int[]numbers,int target){
        if (numbers == null)
            return null;
        int i = 0,j = numbers.length - 1;
        while (i < j){
            int sum = numbers[i] + numbers[j];
            if (sum == target)
                return new int[]{i+1,j+1};
            else if (sum > target)
                j--;
            else
                i++;
        }
        return null;
    }
    public int[]twoSumII(int[]nums,int target){
        int n = nums.length;
        Map<Integer,Integer>map = new HashMap<>();
        for (int i = 0;i < n;i++){
            int other = target - nums[i];;
            if (map.containsKey(other)){
                return new int[]{map.get(other),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
