package daily;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2021-08-2021/8/4 21:22
 */
public class TriangleNumber {
    public int triangleNumber(int[]nums){
        int len = nums.length;
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0;i < len -2;i++){
            for (int j = 0;j < len-1;j++){
                int k = binSearch(nums,j+1,len-1,nums[i]+nums[j]);
                if (k == -1)
                    result += (len - j -1);
                else
                    result += (k - j -1);
            }
        }
        return  result;
    }
    private int binSearch(int[]nums,int left,int right,int target){
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        if (nums[left] < target)
            return -1;
        return left;
    }
}
