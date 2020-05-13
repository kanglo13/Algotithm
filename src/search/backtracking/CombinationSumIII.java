package search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k,int n){
        List<List<Integer>> combinations = new ArrayList<>();
        if (k <= 0 || n <= 0)
            return combinations;
        List<Integer> combineList = new ArrayList<>();
        backtracking(combinations,combineList,1,k,n);
        return combinations;
    }
    private void backtracking(List<List<Integer>> combinations,List<Integer> combineList,int start,int k,int n){
        if (combineList.size() == k && n == 0){
            combinations.add(new ArrayList<>(combineList));
            return;
        }
        for (int i = start;i <= 9;i++){
            if (i <= n){
                combineList.add(i);
                backtracking(combinations,combineList,i+1,k,n-i);
                combineList.remove(combineList.size()-1);
            }
        }
    }
}
