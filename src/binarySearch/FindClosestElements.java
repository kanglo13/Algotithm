package binarySearch;

import javax.lang.model.type.IntersectionType;
import java.util.ArrayList;
import java.util.List;

public class FindClosestElements {
    public List<Integer>findClosestElementsII(int[]arr,int k,int x){
        int len = arr.length;
        int left = 0, right = len - 1;
        int removeSize = len - k;
        while (removeSize-- > 0){
            if (x - arr[left] < arr[right] -x)
                right--;
            else
                left++;
        }
        List<Integer>result = new ArrayList<>();
        for (int i = left;i < left + k;i++){
            result.add(arr[left]);
        }
        return result;
    }
}
