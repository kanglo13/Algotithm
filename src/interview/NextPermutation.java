package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/3 16:42
 */
public class NextPermutation {
    public void  nextPermutation(int[]nums){
        if(nums == null || nums.length == 0)
            return;
        int n = nums.length -1;
        for (int i = n - 1;i >= 0;i--){
            if (nums[i] < nums[i+1]){
                int j = n;
                for (;j  > i && nums[j] <= nums[i];j--);
                swap(nums,i,j);
                reverse(nums,i,j);
                return;
            }
        }
        reverse(nums,0,n);
    }
    private void reverse(int[]nums,int i,int j){
        while (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    private void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
