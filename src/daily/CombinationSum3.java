package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-09-2020/9/11 9:17
 */
public class CombinationSum3 {
    public List<List<Integer>>combinationSum3(int k,int n){
        List<List<Integer>>combinations = new ArrayList<>();
        if (k <=0 || n <= 0)
            return combinations;
        backtracking(combinations,new ArrayList<>(),k,n,1);
        return combinations;
    }
    private void backtracking(List<List<Integer>>combinations,List<Integer>list,int k,int n,int start){
        if (list.size() == k && n == 0 ){
            combinations.add(new ArrayList<>(list));
            return;
        }
        for (int i = start;i <= 9;i++){
            if (i <= n){
                list.add(i);
                backtracking(combinations,list,k,n-i,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
