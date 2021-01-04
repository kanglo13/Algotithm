package daily;

/**
 * @author kanglo
 * @create 2021-01-2021/1/4 10:29
 */
public class Fib {
    public int fib(int n){
        if (n < 2)
            return n;
        int pre2 = 0,pre1 = 1;
        for (int i = 2;i <= n;i++){
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
