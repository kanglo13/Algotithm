package binarySearch;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.Arrays;

public class TriangleNumber {
    public int triangleNumber(int[]nums){
        int len = nums.length;
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0;i < len - 2;i++){
            for (int j = i + 1;j < len - 1;j++){
                int k = findFirstCannotTriangle(nums,j+1,len-1,nums[i]+nums[j]);
                if (k == -1)
                    result += (len - k -1);
                else
                    result += (j - k - 1);
            }
        }
        return result;
    }
    private int findFirstCannotTriangle(int[]nums,int left,int right,int target){
        while (left < right){
            int mid = (left + right) >>> 1;
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
