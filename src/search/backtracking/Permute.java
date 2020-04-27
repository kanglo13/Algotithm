package search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[]nums){
        List<List<Integer>> permute = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        boolean[]hasVisited = new boolean[nums.length];
        backtracking(permute,permuteList,nums,hasVisited);
        return permute;
    }
    private void backtracking(List<List<Integer>>permute,List<Integer> permuteList,int[]nums,boolean[]hasVisited){
        if (permuteList.size() == nums.length){
            permute.add(new ArrayList<>(permuteList));
            return;
        }
        for (int i = 0;i < nums.length;i++){
            if (hasVisited[i])
                continue;
            permuteList.add(nums[i]);
            hasVisited[i] = true;
            backtracking(permute,permuteList,nums,hasVisited);
            permuteList.remove(permuteList.size()-1);
            hasVisited[i] = false;
        }
    }
}
