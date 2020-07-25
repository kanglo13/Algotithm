package binarySearch;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public int[]intersecton(int[]nums1,int[]nums2){
        Set<Integer>set1 = new HashSet<>();
        Set<Integer>set2 = new HashSet<>();
        for (int num : nums1)
            set1.add(num);
        int[]result = new int[nums1.length];
        int index = 0;
        for (int num : nums2){
            set2.add(num);
        }
        for (int val : set1){
            if (set2.contains(val)){
                result[index++] = val;
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }
}
