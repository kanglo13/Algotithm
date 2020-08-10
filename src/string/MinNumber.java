package string;

import java.util.Arrays;

public class MinNumber {
    public String minNumber(int[]nums){
        int n = nums.length;
        String[]strs = new String[n];
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < n;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,(o1, o2) -> (o1+o2).compareTo(o2+o1));
        for(String str : strs)
            result.append(str);
        return  result.toString();

    }
}
