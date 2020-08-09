package sorting.template;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[]nums = new int[]{4,2,3,5,0,9,1};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public  void quickSort(int[]nums){
        quickSort(nums,0,nums.length-1);
    }
    public void quickSort(int[]nums,int l,int h){
        int j = partition(nums,l,h);
        quickSort(nums,l,j-1);
        quickSort(nums,j+1,h);
    }
    private int partition(int[] nums,int l,int h){
        int i = l,j = h + 1;
        int povit = nums[l];
        while(i < j){
            while(i < h && nums[++i] < povit);
            while (j > l && nums[--j] > povit);
            if(i < j)
                swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }
    private void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
