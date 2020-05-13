package search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[]candidates,int target){
        List<List<Integer>> combinations = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return combinations;
        Arrays.sort(candidates);
        List<Integer> combineList = new ArrayList<>();
        boolean[]hasVisited = new boolean[candidates.length];
        backtracking(combinations,combineList,hasVisited,candidates,0,target);
        return combinations;
    }
    private void backtracking(List<List<Integer>> combinations,List<Integer>combineList,boolean[]hasVisited,int[]candidates,int start,int target){
        if (target == 0){
            combinations.add(new ArrayList<>(combineList));
            return;
        }
        for (int i = start;i < candidates.length;i++){
            if (i != 0 && candidates[i] == candidates[i-1] && !hasVisited[i-1])
                continue;
            if (hasVisited[i])
                continue;
            if (candidates[i] <= target){
                combineList.add(candidates[i]);
                hasVisited[i] = true;
                backtracking(combinations,combineList,hasVisited,candidates,i+1,target-candidates[i]);
                hasVisited[i] = false;
                combineList.remove(combineList.size()-1);
            }
        }
    }
}
