package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/5 15:17
 */
public class ClimbStairs {
    public int climbStairs(int n){
        if (n <= 2)
            return n;
        int pre2 = 1, pre1 = 2;
        for (int i = 3;i <= n;i++){
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
