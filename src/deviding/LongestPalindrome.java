package deviding;

/**
 * @author kanglo
 * @create 2020-08-2020/8/16 16:07
 */
public class LongestPalindrome {
    public String longestPalindrome(String s){
        if (s == null || s.length() == 0)
            return "";
        int n = s.length();
        int maxLen = 0;
        int begin = 0;
        boolean[][]dp = new boolean[n][n];
        for (int i = 0;i < n;i++)
            dp[i][i] = true;
        for (int i = n-1;i >= 0;i--){
            for (int j = i+1;j < n;j++){
                if (s.charAt(i) != s.charAt(j))
                    dp[i][j] = false;
                else {
                    if (j-i < 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j] && j - i +1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
