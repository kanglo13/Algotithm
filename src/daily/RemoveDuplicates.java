package daily;

/**
 * @author kanglo
 * @create 2021-04-2021/4/6 16:34
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[]nums){
        int index = 0;
        for (int num : nums){
            if (index <  2 || num > nums[index-2]){
                nums[index++] = num;
            }
        }
        return index;
    }
}
