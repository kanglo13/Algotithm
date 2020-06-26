package dynamicProgramming.subsequence;

public class Racecar {
    public int racecar(int target){
        int[]dp = new int[target+1];
        for (int i = 1;i <= target;i++){
            dp[i] = Integer.MAX_VALUE;
            for (int forward = 1;(1<<forward)-1 < 2*i;forward++){
                int j = (1 << forward)-1;
                if (j == i)
                    dp[i] = forward;
                else if (j  > i){
                    dp[i] = Math.min(dp[i],forward+1+dp[j-i]);
                }
                else {
                    for (int back = 1;back < forward;back++){
                        int k = (1 << back) -1;
                        dp[i] = Math.min(dp[i],forward+1+back+1+dp[i-j+k]);
                    }
                }
            }
        }
        return dp[target];
    }
}
