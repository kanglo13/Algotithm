package search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[]candidates,int target){
        List<List<Integer>> combinations = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return combinations;
        List<Integer>combineList = new ArrayList<>();
        backtracking(combinations,combineList,candidates,target,0);
        return combinations;
    }
    private void backtracking(List<List<Integer>> combinations,List<Integer>combineList,int[]candidates,int target,int start){
        if (target == 0){
            combinations.add(new ArrayList<>(combineList));
            return;
        }
        for (int i = start;i < candidates.length;i++){
            if (candidates[i] <= target){
                combineList.add(candidates[i]);
                backtracking(combinations,combineList,candidates,target-candidates[i],i);
                combineList.remove(combineList.size()-1);
            }
        }
    }
}
