package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kanglo
 * @create 2020-10-2020/10/3 9:43
 */
public class TwoSum {
    public int[] twoSum(int[]nums,int target){
        if (nums == null || nums.length == 0)
            return new int[0];
        Map<Integer,Integer>map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
