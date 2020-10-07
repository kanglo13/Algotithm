package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/7 16:46
 */
public class Merge {
    public int[][]merge(int[][]intervals){
        if (intervals == null || intervals.length < 2)
            return intervals;
        Arrays.sort(intervals,(o1, o2) -> o1[0]-o2[0]);
        int[][]result = new int[intervals.length][2];
        int index = -1;
        for (int[]interval : intervals){
            if (index == -1 || result[index][1] <= interval[0])
                result[++index] = interval;
            else
                result[index][1] = Math.max(interval[1],result[index][1]);
        }
        return Arrays.copyOf(result,index+1);
    }
}
