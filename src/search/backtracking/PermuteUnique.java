package search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[]nums){
        List<List<Integer>>permute = new ArrayList<>();
        if (nums ==null || nums.length == 0)
            return permute;
        List<Integer> permuteList = new ArrayList<>();
        boolean[]hasVisited = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(permute,permuteList,nums,hasVisited);
        return permute;
    }
    private void backtracking(List<List<Integer>> permute,List<Integer>permuteList,int[]nums,boolean[]hasVisited){
        if (permuteList.size() == nums.length){
            permute.add(new ArrayList<>(permuteList));
            return;
        }
        for (int i = 0;i < nums.length;i++){
            if (i != 0 && nums[i-1] == nums[i] && !hasVisited[i-1])
                continue;
            if (hasVisited[i])
                continue;
            permuteList.add(nums[i]);
            hasVisited[i] = true;
            backtracking(permute,permuteList,nums,hasVisited);
            hasVisited[i] = false;
            permuteList.remove(permuteList.size()-1);
            
        }
    }
}
