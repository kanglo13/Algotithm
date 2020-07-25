package binarySearch;

public class SearchII {
    public boolean search(int[]nums,int target){
        int len = nums.length;
        if (len == 0)
            return false;
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[left]){
                if (nums[left] <= target && target <= nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else if (nums[mid] < nums[left]){
                if (target >= nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
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
