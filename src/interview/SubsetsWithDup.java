package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/5 10:26
 */
public class SubsetsWithDup {
    public List<List<Integer>>subsetsWithDup(int[]nums) {
        List<List<Integer>>subsets = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return subsets;
        boolean[]hasVisited = new boolean[nums.length];
        List<Integer>tempSet = new ArrayList<>();
        Arrays.sort(nums);
        for (int size = 0; size <= nums.length;size++){
            backtracking(subsets,tempSet,hasVisited,nums,0,size);
        }
        return subsets;
    }
    private void backtracking(List<List<Integer>>subsets,List<Integer>tempSet,boolean[]hasVisited,int[]nums,int start,int size){
        if (size == tempSet.size()){
            subsets.add(new ArrayList<>(tempSet));
        }
        for (int i = start;i < nums.length;i++){
            if (i != 0 && nums[i] == nums[i-1] && !hasVisited[i-1])
                continue;
            if (hasVisited[i])
                continue;
            tempSet.add(nums[i]);
            hasVisited[i] = true;
            backtracking(subsets,tempSet,hasVisited,nums,i+1,size);
            hasVisited[i] =false;
            tempSet.remove(tempSet.size()-1);
        }
    }
}
