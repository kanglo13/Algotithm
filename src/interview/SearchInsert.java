package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/18 15:52
 */
public class SearchInsert {
    public int searchInsert(int[]nums,int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (right + left) >>> 1;
            if (nums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
