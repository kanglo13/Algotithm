package dynamicProgramming.subsequence;

import sun.font.DelegatingShape;

public class CountPalindromicSubsequences {
    public int countPalindromicSubsequences(String s){
        int n = s.length();
        int[][]dp = new int[n][n];
        for (int i = 0;i < n;i++){
            dp[i][i] = 1;
        }
        char[] ch = s.toCharArray();
        for (int i = n -1;i >= 0;i--){
            for (int j = i +1;j < n;j++){
                if (ch[i] != ch[j])
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                else if (ch[i] == ch[j]){
                    dp[i][j] = dp[i+1][j-1] * 2;
                    int l = i +1, r = j -1;
                    while (l <= r && ch[l] != ch[j])l++;
                    while (l <= r && ch[r] != ch[j])r--;
                    if (l > r)
                        dp[i][j] += 2;
                    else if (l == r)
                        dp[i][j] += 1;
                    else if (l < r)
                        dp[i][j] -= dp[l+1][r-1];

                }
            }
        }
        return dp[0][n-1];
    }
}
