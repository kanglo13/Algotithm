package daily;

public class FindMagicIndex {
    public int findMagicIndex(int[]nums){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if (nums[mid] == mid)
                return mid;
            else if (nums[mid] < mid)
                left++;
            else
                right--;
        }
        return -1;
    }
}
