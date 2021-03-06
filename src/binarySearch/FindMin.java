package binarySearch;

public class FindMin {
    public int findMin(int[]nums){
        int left = 0, right = nums.length -1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else if (nums[mid] <= nums[right])
                right = mid;
        }
        return left;
    }
    public int findMinII(int[]nums){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else if (nums[mid] < nums[right])
                right = mid;
            else
                right--;
        }
        return nums[left];
    }
}
