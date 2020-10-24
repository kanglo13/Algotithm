package interview;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author kanglo
 * @create 2020-10-2020/10/22 21:42
 */
public class MergeII {
    public int[][]merge(int[][]intervals){
        int n = intervals.length;
        int[][]result = new int[n][2];
        int index = -1;
        Arrays.sort(intervals,(o1, o2) -> o1[0]-o2[0]);
        for (int[]interval : intervals){
            if (index == -1){
                result[++index] = interval;
            }
            else if (interval[0] <= result[index][1]){
                result[index][1] = Math.max(result[index][1],interval[1]);
            }
            else
                result[++index] = interval;
        }
        return Arrays.copyOfRange(result,0,index+1);
    }
}
