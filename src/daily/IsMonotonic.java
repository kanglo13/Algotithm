package daily;

/**
 * @author kanglo
 * @create 2021-02-2021/2/28 17:09
 */
public class IsMonotonic {
    public boolean isMonotonic(int[]A){
        if (A.length <= 2)
            return true;
        int a = 0, b = 0;
        for (int i = 1;i < A.length;i++){
            if (A[i] >A[i-1])
                a = 1;
            if (A[i] < A[i-1])
                b = 1;
        }
        if (a + b ==2)
            return false;
        return true;
    }
}
