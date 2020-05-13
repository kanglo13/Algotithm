package search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[]nums){
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return subsets;
        List<Integer> tempSet = new ArrayList<>();
        for (int size = 0; size <= nums.length;size++){
            backtracking(subsets,tempSet,nums,0,size);
        }
        return subsets;
    }
    private void backtracking(List<List<Integer>>subsets,List<Integer>tempSet,int[]nums,int start,int size){
        if (tempSet.size() == size){
            subsets.add(new ArrayList<>(tempSet));
            return;
        }
        for (int i = start;i < nums.length;i++){
            tempSet.add(nums[i]);
            backtracking(subsets,tempSet,nums,i+1,size);
            tempSet.remove(tempSet.size()-1);
        }
    }
}
