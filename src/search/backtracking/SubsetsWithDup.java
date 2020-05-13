package search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[]nums){
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return subsets;
        List<Integer> tempSet = new ArrayList<>();
        boolean[]hasVisited = new boolean[nums.length];
        Arrays.sort(nums);
        for (int size = 0; size <= nums.length;size++){
            backtracking(subsets,tempSet,nums,hasVisited,0,size);
        }
        return subsets;
    }
    private void backtracking(List<List<Integer>>subsets,List<Integer>tempSet,int[]nums,boolean[]hasVisited,int start,int size){
        if (tempSet.size() == size){
            subsets.add(new ArrayList<>(tempSet));
            return;
        }
        for (int i = start;i < nums.length;i++){
            if (i != 0 && nums[i] == nums[i-1] && !hasVisited[i-1])
                continue;
            hasVisited[i] = true;
            tempSet.add(nums[i]);
            backtracking(subsets,tempSet,nums,hasVisited,i+1,size);
            hasVisited[i] = false;
            tempSet.remove(tempSet.size()-1);
        }
    }
}
