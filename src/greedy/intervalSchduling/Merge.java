package greedy.intervalSchduling;

import java.util.Arrays;

public class Merge {
    public int[][]merge(int[][]intervals){
        Arrays.sort(intervals,(o1, o2) -> o1[0]-o2[0]);
        int[][]result = new int[intervals.length][2];
        int index = -1;
        for (int[]interval : intervals){
            if (index == -1 || interval[0] > result[index][1])
                result[++index] = interval;
            else
                result[index][1] = Math.max(result[index][1],interval[1]);
        }
        return Arrays.copyOf(result,index+1);
    }
}
