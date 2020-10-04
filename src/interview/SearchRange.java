package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/3 22:10
 */
public class SearchRange {
    public int[]searchRange(int[]nums,int target){
        if (nums == null || nums.length == 0)
            return new int[]{-1,-1};
        int left = leftBoundSearch(nums,target);
        if (left == nums.length || nums[left] != target)
            return new int[]{-1,-1};
        int right = leftBoundSearch(nums,target+1)-1;
        return new int[]{left,right};
    }
    private int leftBoundSearch(int[]nums,int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = ( right + left) >>> 1;
            if (nums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
