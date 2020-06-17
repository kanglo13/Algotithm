package binarySearch;

public class BinarySearch {
    public int binarySearch(int[]nums,int target){
        int left = 0,right = nums.length -1;
        while (left <= right){
            int mid = left + (right -left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid -1;
            else
                left = mid + 1;
        }
        return -1;
    }
    public int leftBounds(int[]nums,int target){
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target)
                right = mid -1;
            else if (nums[mid] < target)
                left = mid + 1;
        }
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
    public int rightBounds(int[]nums,int target){
        int left = 0, right = nums.length -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target)
                left = mid + 1;
            else if (nums[mid] >target)
                right = mid -1;
        }
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }
}
