package daily;

/**
 * @author kanglo
 * @create 2021-04-2021/4/7 21:47
 */
public class Search {
    public boolean search(int[]nums,int target){
        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[left]){
                if (nums[left] <= target && target <= nums[mid])
                    right = mid;
                else
                    left = mid + 1;
            }
            else if (nums[mid] < nums[left]){
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid;
            }
            else {
                if (nums[left] == target)
                    return true;
                else
                    left++;
            }
        }
        return nums[left] == target;
    }
}
