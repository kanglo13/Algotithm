package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 10:52
 */
public class PermuteII {
    public List<List<Integer>>permute(int[]nums){
        List<List<Integer>>permutations = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return permutations;
        boolean[]hasVisited = new boolean[nums.length];
        backtracking(permutations,new ArrayList<>(),nums,hasVisited);
        return permutations;
    }
    private void backtracking(List<List<Integer>>permutations,List<Integer>tempList,int[]nums,boolean[]hasVisited){
        if (tempList.size() == nums.length){
            permutations.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0;i <nums.length;i++){
            if (hasVisited[i])
                continue;
            tempList.add(nums[i]);
            hasVisited[i] = true;
            backtracking(permutations,tempList,nums,hasVisited);
            tempList.remove(tempList.size()-1);
            hasVisited[i] = false;
        }
    }
}
