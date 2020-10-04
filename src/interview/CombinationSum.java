package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/4 11:22
 */
public class CombinationSum {
    public List<List<Integer>>combinationSum(int[]candidates,int target){
        List<List<Integer>>combinations = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return combinations;
        backtracking(combinations,new ArrayList<>(),candidates,0,target);
        return combinations;
    }
    private void backtracking(List<List<Integer>>combinations,List<Integer>combinationList,int[]candidates,int start,int target){
        if (target == 0){
            combinations.add(new ArrayList<>(combinationList));
            return;
        }
        for (int i = start;i < candidates.length;i++){
            if (candidates[i] <= target){
                combinationList.add(candidates[i]);
                backtracking(combinations,combinationList,candidates,start,target-candidates[i]);
                combinationList.remove(combinationList.size()-1);
            }
        }
    }
}
