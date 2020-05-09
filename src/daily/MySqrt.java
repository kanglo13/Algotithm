package daily;

public class MySqrt {
    public int mySqrt(int x){
        if (x <= 1)
            return x;
        int l = 1, h = x / 2;
        while (l < h){
            int m = l + (h - l) / 2;
            int sqrt = x / m;
            if (sqrt == m)
                return sqrt;
            else if (m > sqrt)
                h = m - 1;
            else
                l = m + 1;
        }
        return h;
    }
}
