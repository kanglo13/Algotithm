package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/16 22:33
 */
public class RemoveDuplicatesII {
    public int removeDuplicates(int[]nums){
        if (nums == null || nums.length == 0)
            return 0;
        int index = 0, i = 1;
        while (i < nums.length) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
            i++;
        }
        return index+1;
    }
}
