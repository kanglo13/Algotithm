package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-09-2020/9/18 9:08
 */
public class PermuteUnique {
    public List<List<Integer>>permuteUnique(int[]nums){
        List<List<Integer>>permutation = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return permutation;
        Arrays.sort(nums);
        int len = nums.length;
        boolean[]hasVisited = new boolean[len];
        backtracking(permutation,new ArrayList<>(),hasVisited,nums);
        return permutation;

    }
    private void backtracking(List<List<Integer>>permutation,List<Integer>tempList,boolean[]hasVisited,int[]nums){
        if (tempList.size() == nums.length){
            permutation.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0;i < nums.length;i++){
            if (i != 0 && nums[i] == nums[i-1] && !hasVisited[i-1])
                continue;
            if (hasVisited[i])
                continue;
            tempList.add(nums[i]);
            hasVisited[i] = true;
            backtracking(permutation,tempList,hasVisited,nums);
            hasVisited[i] = false;
            tempList.remove(tempList.size()-1);
        }
    }
}
