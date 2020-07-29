package greedy.intervalSchduling;

import java.util.ArrayList;
import java.util.List;

public class IntervalInsertsection {
    public int[][]intervalInsertsection(int[][]A,int[][]B){
        List<int[]>result = new ArrayList<>();
        int i = 0,j = 0;
        while (i < A.length && j < B.length){
            int start = Math.max(A[i][0],B[j][0]);
            int end = Math.min(A[i][1],B[j][1]);
            if (start <= end)
                result.add(new int[]{start,end});
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
