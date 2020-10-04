package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/3 21:52
 */
public class Search {
    public int search(int[]nums,int target){
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (right + left) >>> 1;
            if(nums[mid] == target)
                return mid;
            if (nums[mid]  <= nums[right]){
                if (target > nums[mid] && target<= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            else {
                if (target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}
