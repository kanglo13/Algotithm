package interview;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 18:27
 */
public class SmallestK {
    public int[]smallestK(int[]arr,int k){
        int left = 0, right = arr.length-1;
        while (left < right){
            int pos = partition(arr,left,right);
            if (pos == k-1)
                break;
            else if (pos < k-1)
                left = pos + 1;
            else
                right = pos - 1;
        }
        return Arrays.copyOfRange(arr,0,k-1);
    }
    private int partition(int[]nums,int l,int h){
        int i = l , j = h + 1;
        int pivot = nums[l];
        while (true){
            while (i != h && nums[++i] < pivot);
            while (j != l && nums[--j] > pivot);
            if (i >= j)
                break;
            swap(nums,i,j);
        }
        swap(nums,j,l);
        return j;
    }
    private void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
