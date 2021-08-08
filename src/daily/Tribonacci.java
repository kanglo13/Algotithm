package daily;

/**
 * @author kanglo
 * @create 2021-08-2021/8/8 9:30
 */
public class Tribonacci {
    public int tribonacci(int n){
        if (n == 0)
            return 0;
        else if (n < 3)
            return 1;
        int pre2  = 0, pre1 = 1, pre0 = 1;
        for (int i = 3;i <= n;i++){
            int cur = pre0 + pre1 + pre2;
            pre2 = pre1;
            pre1 = pre0;
            pre0 = cur;
        }
        return pre0;
    }
}
