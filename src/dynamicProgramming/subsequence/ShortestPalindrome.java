package dynamicProgramming.subsequence;

public class ShortestPalindrome {
    public String shortestPalindrome(String s){
        s = new StringBuilder(s).reverse().append(s).toString();
        int n = s.length();
        int maxLen = 0;
        int begin = 0;
        boolean[][]dp = new boolean[n][n];
        for (int i = 0;i < n;i++)
            dp[i][i] = true;
        for (int j = 1;j < n;j++){
            for (int i = 0;i < j;i++){
                if (s.charAt(i) != s.charAt(j))
                    dp[i][j] = false;
                else {
                    if ((j-i<3) || dp[i+1][j-1])
                        dp[i][j] = true;
                }
                if(dp[i][j] && j-i+1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
