package daily;
/*
假设求a^b,按照朴素算法就是把a连乘b次，这样一来时间复杂度是O(n)级，快速幂能做到O(logn)
首先把b写成它的二进制形式，设该二进制数第i位的权值为2^(i-1)，i * 2^(i-1)是每一次要做的乘方次数
那么假设b=11，11的二进制是1011，11 = 2³×1 + 2²×0 + 2¹×1 + 2º×1=2³+2¹+2º，所以：a¹¹= a^2º* a ^2¹ * a^2³

代码中n&1是取末位，只有当前位为1时才要乘； n/=2是将n右移一位，取新的位做末位；x*=x就是X^(2^i)，是下一次要乘的因子

 */
public class MyPow {
    public double myPow(double x,int n){
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n == -1)
            return 1/x;
        double half = myPow(x,n / 2);
        double rest = myPow(x,n % 2);
        return  half * half * rest;
    }
    public double myPowII(double x,int n){
        boolean isNegative = n <= 0;
        double answer = 1;
        while (n != 0){
            if ((n&1) != 0) {
                answer *= x;
            }
            x *= x;
            n /= 2;
        }
        return isNegative ? 1.0 / answer : answer;
    }
}
