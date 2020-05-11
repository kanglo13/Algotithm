package greedy.intervalSchdule;

import java.util.Arrays;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][]points){
        if (points == null || points.length == 0)
            return 0;
        Arrays.sort(points,(o1, o2) -> o1[1] - o2[1]);
        int count = 1;
        int end = points[0][1];
        for (int[]point : points){
            int start = point[0];
            if (start > end){
                count++;
                end = point[1];
            }
        }
        return count;
    }
}
