package search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n,int k){
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        backtracking(combinations,combineList,1,n,k);
        return combinations;
    }
    private void backtracking(List<List<Integer>> combinations,List<Integer>combineList,int start,int n,int k){
        if (combineList.size() == k){
            combinations.add(new ArrayList<>(combineList));
            return;
        }

        for (int i = start;i <= n -(k - combineList.size())+1;i++){
            combineList.add(i);
            backtracking(combinations,combineList,i+1,n,k);
            combineList.remove(combineList.size()-1);
        }
    }
}
