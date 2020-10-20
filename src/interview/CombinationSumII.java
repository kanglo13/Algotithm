package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 10:32
 */
public class CombinationSumII {
    public List<List<Integer>>combinationSum(int[]candidates,int target){
        List<List<Integer>>result = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return result;
        backtracking(result,new ArrayList<>(),candidates,target,0);
        return result;
    }
    private void backtracking(List<List<Integer>>result,List<Integer>tempList,int[]candidates,int target,int start){
        if (target == 0){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start;i < candidates.length;i++){
            if (candidates[i] <= target){
                tempList.add(candidates[i]);
                backtracking(result,tempList,candidates,target-candidates[i],i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
