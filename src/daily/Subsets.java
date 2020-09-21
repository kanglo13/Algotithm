package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-09-2020/9/20 9:45
 */
public class Subsets {
    public List<List<Integer>>subsets(int[]nums){
        List<List<Integer>>subsets = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return subsets;

        for (int size = 0; size <= nums.length;size++){
            backtracking(subsets,new ArrayList<>(),nums,size,0);
        }
        return subsets;

    }
    private void backtracking(List<List<Integer>>subsets,List<Integer>setList,int[]nums,int size,int start){
        if (setList.size() == size){
            subsets.add(new ArrayList<>(setList));
            return;
        }
        for (int i = start;i < nums.length;i++){
            setList.add(nums[i]);
            backtracking(subsets,setList,nums,size,i+1);
            setList.remove(setList.size()-1);
        }
    }
}
