package daily;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author kanglo
 * @create 2020-11-2020/11/4 15:54
 */
public class Insert {
    public static void main(String[] args) {
        Insert insert = new Insert();
        int[][]interval = new int[][]{{1,3},{6,9}};
        int[]newInterval = new int[]{2,5};
        System.out.println(Arrays.deepToString(insert.insert(interval, newInterval)));
    }
    public int[][]insert(int[][]intervals,int[]newInterval){
        int n = intervals.length;
        int[][]intervalss = new int[n+1][2];
        for (int index = 0;index < n;index++){
            intervalss[index] = intervals[index];
        }
        intervalss[n] = newInterval;
        Arrays.sort(intervalss,(o1, o2) -> o1[0]-o2[0]);
        int[][] result = new int[n+1][2];
        int index = -1;
        for (int[]interval : intervalss){
            if (index == -1){
                result[++index] = interval;
            }
            else if (interval[0] <= result[index][1]){
                result[index][1] = Math.max(interval[1],result[index][1]);
            }
            else {
                result[++index] = interval;
            }
        }
        return Arrays.copyOfRange(result,0,index+1);
    }
}
