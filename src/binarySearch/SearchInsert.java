package binarySearch;

/**
 * @author kanglo
 * @create 2021-08-2021/8/9 23:21
 */
public class SearchInsert {
    public int searchInsert(int[]nums,int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

}
