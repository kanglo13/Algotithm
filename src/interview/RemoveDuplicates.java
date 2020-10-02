package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/2 11:15
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[]nums){
        if (nums == null || nums.length == 0)
            return 0;
        int i = 0, j = 1;
        while (j < nums.length){
            if (nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
}
