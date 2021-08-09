package binarySearch;

/**
 * @author kanglo
 * @create 2021-08-2021/8/8 23:33
 */
public class SearchRangeII {
    public int[]searchRange(int[]nums,int target){
        if (nums == null || nums.length == 0)
            return new int[] {-1,-1};
        int n = nums.length;
        int left = leftBinsearch(nums,0,n-1,target);
        if (left == -1)
            return new int[]{-1,-1};
        int right = rightBinSearch(nums,0,n-1,target);
        return new int[]{left,right};

    }
    private int leftBinsearch(int[]nums,int left ,int right,int target){
        while (left < right){
            int mid = left + (right -left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        if (nums[left] != target)
            return -1;
        return left;
    }
    private int rightBinSearch(int[]nums,int left,int right,int target){
        while (left < right){
            int mid = left + (right -left+1) / 2;
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid;
        }
        return left;
    }


}
