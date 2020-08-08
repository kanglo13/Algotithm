package dynamicProgramming.arrayInterval;

public class NthSuperUglyNumber {
    public int nthSuperUglyNumber(int n,int[]primes){
        int[]dp = new int[n];
        dp[0] = 1;
        int len = primes.length;
        int[]index = new int[len];
        for (int i = 1;i < n;i++){
            int min = Integer.MAX_VALUE;
            for (int j = 0;j < len;j++){
                if (min > dp[index[j]] * primes[j])
                    min = dp[index[j]] * primes[j];
            }
            dp[i] = min;
            for (int j = 0;j < len;j++){
                if (min == dp[index[j]] * primes[j])
                    index[j]++;
            }
        }
        return dp[n-1];
    }
}
