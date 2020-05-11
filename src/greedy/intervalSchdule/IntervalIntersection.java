package greedy.intervalSchdule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {
    public int[][] intervalIntersection(int[][]A,int[][]B){
        int m = A.length, n = B.length;
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        int index = 0;
        while (i < m && j < n){
            int a1 = A[i][0],a2 = A[i][1];
            int b1 = B[j][0],b2 = A[j][1];
            if (a2 >= b1 && b2 >= a1){
                int start = Math.max(a1,b1);
                int end = Math.min(a2,b2);
                res.add(new int[]{start,end});
            }

            if(a2 < b2)
                i++;
            else
                j++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
