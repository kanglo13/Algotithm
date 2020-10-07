package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/4 22:06
 */
public class CombinationSum2 {
    public List<List<Integer>>combinationSum2(int[]candidates,int target){
        List<List<Integer>>combinations = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return combinations;
        int n = candidates.length;
        Arrays.sort(candidates);
        boolean[]hasVisited = new boolean[n];
        backtracking(combinations,new ArrayList<>(),hasVisited,candidates,0,target);
        return combinations;
    }
    private void backtracking(List<List<Integer>>combinations,List<Integer>combinationList,
                              boolean[]hasVisited,int[]candidates,int start,int target){
        if (target == 0){
            combinations.add(new ArrayList<>(combinationList));
            return;
        }
        for (int i = start;i < candidates.length;i++){
            if (i != 0 && candidates[i] == candidates[i-1] && !hasVisited[i-1])
                continue;
            if (hasVisited[i])
                continue;
            if (candidates[i] <= target){
                combinationList.add(candidates[i]);
                hasVisited[i] = true;
                backtracking(combinations,combinationList,hasVisited,candidates,i+1,target-candidates[i]);
                hasVisited[i] = false;
                combinationList.remove(combinationList.size()-1);
            }
        }
    }
}
