package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-09-2020/9/10 8:37
 */
public class CombinationSum2 {
    public List<List<Integer>>combinationSum2(int[]candidates,int target){
        List<List<Integer>>combinations = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return combinations;
        int n = candidates.length;
        boolean[]hasVisited = new boolean[n];
        Arrays.sort(candidates);
        backtracking(combinations,new ArrayList<>(),hasVisited,candidates,target,0);
        return combinations;

    }
    private void backtracking(List<List<Integer>>combinations,List<Integer>list,boolean[]hasVisited,int[]candidates,int target,int start){
        if (target == 0){
            combinations.add(new ArrayList<>(list));
            return;
        }
        for (int i = start;i < candidates.length;i++){
            if (i != 0 && !hasVisited[i-1] && candidates[i] == candidates[i-1])
                continue;
            if (hasVisited[i])
                continue;
            if (candidates[i] <= target){
                list.add(candidates[i]);
                hasVisited[i] = true;
                backtracking(combinations,list,hasVisited,candidates,target-candidates[i],i+1);
                list.remove(list.size()-1);
                hasVisited[i] = false;
            }
        }
    }
}
