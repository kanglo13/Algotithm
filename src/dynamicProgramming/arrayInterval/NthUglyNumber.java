package dynamicProgramming.arrayInterval;

public class NthUglyNumber {
    public int nthUglyNumber(int n){
        int[]dp = new int[n];
        dp[0] = 1;
        int index2 = 0,index3= 0,index5= 0;
        for (int i = 1;i < n;i++){
            int next2 = dp[index2]*2;
            int next3 = dp[index3] * 3;
            int next5 = dp[index5]*5;
            int min = Math.min(next2,Math.min(next3,next5));
            dp[i] = min;
            if (next2 == min)
                index2++;
            if (next3== min)
                index3++;
            if (next5== min)
                index5++;
        }
        return dp[n-1];
    }
}
