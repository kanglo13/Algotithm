package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/13 22:18
 */
public class MaxSubArrayCircular {
    public int maxSubArrayCircular(int[]A){
        if (A == null || A.length == 0)
            return 0;
        int curMax,max,curMin,min,sum;

        curMax = max = curMin = min =sum = A[0];
        for (int i = 1;i < A.length;i++){
            sum += A[i];
            curMax = curMax > 0 ? curMax + A[i] : A[i];
            max = Math.max(curMax, max);
            curMin = curMin < 0 ? curMin + A[i] : A[i];
            min = Math.min(min,curMin);
        }
        if (max < 0)
            return max;
        return Math.max(max,sum-min);
    }
}
