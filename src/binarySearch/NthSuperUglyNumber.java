package binarySearch;

/**
 * @author kanglo
 * @create 2021-08-2021/8/9 21:36
 */
public class NthSuperUglyNumber {
    public int nthSuperUglyNumber(int n,int[] primes){
        int[]dp = new int[n];
        dp[0] = 1;
        int len = primes.length;
        int[]index = new int[len];
        int[]next = new int[len];
        for (int i = 1;i < n;i++){
            for (int j = 0;j < len;j++){
                next[j] = dp[index[j]] * primes[j];
            }
            int min = min(next);
            dp[i] = min;
            for (int j = 0; j < len;j++){
                if (min == next[j])
                    index[j]++;
            }
        }
        return dp[n-1];
    }
    private int min(int[]nums){
        int result = Integer.MAX_VALUE;
        for (int num : nums){
            result = Math.min(num,result);
        }
        return result;
    }
}
