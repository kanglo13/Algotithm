package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/16 22:41
 */
public class NextPermutations {
    public void nextPermutations(int[]nums){
        if (nums == null || nums.length == 0)
            return;
        int n = nums.length - 1;
        for (int i = n - 1;i >= 0;i--){
            if (nums[i] < nums[i+1]){
                int j = n;
                while (j > i && nums[j] <= nums[i])
                    j--;
                swap(nums,i,j);
                reverse(nums,i+1,n);
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
