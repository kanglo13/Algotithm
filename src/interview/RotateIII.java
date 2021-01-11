package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 19:29
 */
public class RotateIII {
    public void  rotate(int[]nums,int k){
        int n = nums.length;
        reverse(nums,0,n-1);
        reverse(nums,k,n);
    }
    private void  reverse(int[]nums,int i,int j){
        while (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}