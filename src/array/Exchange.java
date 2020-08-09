package array;

public class Exchange {
    public int[]exchange(int[]nums){
        int left = 0, right = nums.length - 1;
        while(true){
            while (left < right && (nums[left] & 1) != 0)
                left++;
            while(left < right && (nums[right] & 1) == 0)
                right--;
            if(left >= right)
                break;
            swap(nums,left,right);
        }
        return nums;
    }
    private void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
