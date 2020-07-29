package dynamicProgramming.zone;

public class StrangePrinter {
    public int strangePrinter(String s){
        if (s == null || s.length() <= 0)
            return 0;
        int n = s.length();
        int[][]dp = new int[n][n];
        for (int i = 0;i < n;i++)
            dp[i][i] = 1;
        for (int len = 2;len <= n;len++){
            for (int left = 0;left <= n -len;left++){
                int right = left + len - 1;
                if (s.charAt(left) == s.charAt(right)){
                    dp[left][right] = dp[left][right-1];
                    continue;
                }
                dp[left][right] = dp[left][right-1] + 1;
                for (int i = left;i < right;i++){
                    if (s.charAt(i) == s.charAt(right)){
                        dp[left][right] = Math.min(dp[left][right],dp[left][i-1]+dp[i][right-1]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
