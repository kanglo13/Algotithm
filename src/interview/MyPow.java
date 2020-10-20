package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 11:26
 */
public class MyPow {
    public double myPow(double x,int n){
        if (x == 0.0f)
            return 0.0d;
        long b = n;
        if (n < 0){
            x = 1 / x;
            b = -b;
        }
        double result = 1.0;
        while (b > 0){
            if ((b&1) == 1)
                result *= x;
            x *= x;
            b >>= 1;
        }
        return result;
    }
}
