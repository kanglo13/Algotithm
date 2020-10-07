package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/5 10:48
 */
public class PermuteUnique {
    public List<List<Integer>>permuteUnique(int[]nums){
        List<List<Integer>>permutations = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return permutations;
        Arrays.sort(nums);
        boolean[]hasVisited = new boolean[nums.length];
        backtracking(permutations,new ArrayList<>(),nums,hasVisited);
        return permutations;
    }
    private void backtracking(List<List<Integer>>permutations,List<Integer>tempPermutation,int[]nums,boolean[]hasVisited){
        if (tempPermutation.size() == nums.length){
            permutations.add(new ArrayList<>(tempPermutation));
            return;
        }
        for (int i = 0;i < nums.length;i++){
            if (i != 0 && nums[i] == nums[i-1] && !hasVisited[i-1])
                continue;
            if (hasVisited[i])
                continue;
            tempPermutation.add(nums[i]);
            hasVisited[i] = true;
            backtracking(permutations,tempPermutation,nums,hasVisited);
            hasVisited[i] = false;
            tempPermutation.remove(tempPermutation.size()-1);
        }
    }
}
