package array;

public class RemoveElement {
    public int removeElement(int[]nums,int val){
        int count = 0;
        for (int num : nums){
            if (num == val)
                count++;
        }
        for (int i = 0;i < nums.length - count;i++){
            if (nums[i] == val)
                swap(nums,i,i+1);
        }
        return nums.length - count;

    }
    private void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]  = temp;
    }
}
