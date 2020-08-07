package daily;

public class NextPermutation {
    public void nextPermutation(int[]nums){
        int n = nums.length - 1;
        for (int i = n - 1;i >=0;i--){
            if(nums[i] < nums[i+1]){
                int j = n - 1;
                for(;j > i && nums[j] <= nums[i];j--);
                swap(nums,i,j);
                reverse(nums,j+1,n);
                return;
            }
        }
        reverse(nums,0,n);
    }
    private void reverse(int[]nums,int i,int j){
        while (i < j){
            swap(nums,i++,j--);
        }
    }
    private void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
