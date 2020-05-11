package greedy.intervalSchdule;

import java.util.Arrays;

public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][]intervals){
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals,(o1, o2) -> o1[1] - o2[1]);

        int count = 1;
        int end = intervals[0][1];
        for (int[]interval : intervals){
            int start = interval[0];
            if (start >= end){
                count++;
                end = interval[1];
            }
        }
        return intervals.length - count;
    }
}
