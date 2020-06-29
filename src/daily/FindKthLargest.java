package daily;

public class FindKthLargest {
    public int findKthLargest(int[]nums,int k){
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        k = n - k;
        int l = 0, h = n -1;
        while (true){
            int index = partition(nums,l,h);
            if (index == k)
                return nums[index];
            else if(index > k)
                h = index - 1;
            else l = index + 1;

        }
    }
    private int partitionII(int[]nums,int l,int h){
        int i = l,j = h + 1;
        int pivot = nums[l];
        while (true){
            while (i != h && nums[++i] < pivot);
            while (j != l && nums[--j] > pivot);
            if (i >= j)
                break;
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }
    private int partition(int[]nums,int l,int h){
        int i = l,j = h+1;
        int v = nums[l];
        while (true){
            while (i != h && nums[++i] < v);
            while (j != l && v < nums[--j]);
            if (i >= j)
                break;
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
