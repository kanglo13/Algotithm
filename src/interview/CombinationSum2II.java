package interview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 10:42
 */
public class CombinationSum2II {
    public List<List<Integer>>combinationSum2(int[]candidates,int target){
        List<List<Integer>>result = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return result;
        Arrays.sort(candidates);
        boolean[]hasVisited = new boolean[candidates.length];
        backtracking(result,new ArrayList<>(),candidates,hasVisited,target,0);
        return result;
    }
    private void backtracking(List<List<Integer>>result,List<Integer>tempList,int[]candidates,boolean[]hasVisited,int target,int start){
        if (target == 0){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start;i < candidates.length;i++){
            if (i != 0 && candidates[i] == candidates[i-1] &&!hasVisited[i-1])
                continue;
            if (hasVisited[i])
                continue;
            if (candidates[i] <= target){
                tempList.add(candidates[i]);
                hasVisited[i] = true;
                backtracking(result,tempList,candidates,hasVisited,target-candidates[i],i+1);
                tempList.remove(tempList.size()-1);
                hasVisited[i] = false;
            }
        }
    }
}
