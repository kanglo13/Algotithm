package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/4 22:00
 */
public class Permute {
    public List<List<Integer>>permute(int[]nums){
        List<List<Integer>>permute = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return permute;
        int n =  nums.length;
        boolean[]hasVisited = new boolean[n];
        backtracking(permute,new ArrayList<>(),nums,hasVisited);
        return permute;

    }
    private void backtracking(List<List<Integer>>permute,List<Integer>permutationList,int[]nums,boolean[]hasVisited){
        if (permutationList.size() == nums.length){
            permute.add(new ArrayList<>(permutationList));
            return;
        }
        for (int i = 0;i < nums.length;i++){
            if (hasVisited[i])
                continue;
            permutationList.add(nums[i]);
            hasVisited[i] = true;
            backtracking(permute,permutationList,nums,hasVisited);
            hasVisited[i] = false;
            permutationList.remove(permutationList.size()-1);
        }
    }
}
