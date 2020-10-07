package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/5 10:20
 */
public class Subsets {
    public List<List<Integer>>subsets(int[]nums){
        List<List<Integer>>subsets = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return subsets;
        for (int size = 0;size <= nums.length;size++){
            backtracking(subsets,new ArrayList<>(),nums,size,0);
        }
        return subsets;
    }
    private void backtracking(List<List<Integer>>subsets,List<Integer>tempSet,int[]nums,int size,int start){
        if (tempSet.size() == size){
            subsets.add(new ArrayList<>(tempSet));
            return;
        }
        for (int i = start;i < nums.length;i++){
            tempSet.add(nums[i]);
            backtracking(subsets,tempSet,nums,size,i+1);
            tempSet.remove(tempSet.size()-1);
        }
    }
}
