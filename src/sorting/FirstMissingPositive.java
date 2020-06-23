package sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public int firstMissingPositive(int[]nums){
        int len = nums.length;
        Set<Integer>set = new HashSet<>();
        for (int num :nums)
            set.add(num);
        for (int i = 1;i <= len;i++){
            if (!set.contains(i))
                return i;
        }
        return len+1;
    }
    public int firstMissingPositiveII(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 1; i <= len; i++) {
            int res = binarySearch(nums, i);
            if (res == -1) {
                return i;
            }
        }
        return len + 1;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public int firstMissingPositiveIII(int[]nums){
        int len = nums.length;
        for (int i = 0;i < len;i++){
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i]-1] != nums[i])
                swap(nums,nums[i]-1,i);
        }
        for (int i = 0;i <len;i++){
            if (nums[i] != i+1)
                return i+1;
        }
        return len+1;
    }
    private void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
