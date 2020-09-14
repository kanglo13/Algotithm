package interview;

/**
 * @author kanglo
 * @create 2020-09-2020/9/13 16:51
 */
public class LongestPalindrome {
    public String longestPalindrome(String s){
         if (s == null || s.length() == 0)
             return "";
         if (s.length() < 2)
             return s;
         int maxLen = 0, begin = 0;
         int n = s.length();
         boolean[][]dp = new boolean[n][n];
         for (int i = 0;i < n;i++){
             dp[i][i] = true;
         }
         for (int j = 1;j < n;j++){
             for (int i = 0;i < j;i++){
                 if (s.charAt(i) != s.charAt(j))
                     dp[i][j] = false;
                 else {
                     if (j - i < 3)
                         dp[i][j] = true;
                     else
                         dp[i][j] = dp[i+1][j-1];
                 }
                 if (dp[i][j] && j - i + 1 > maxLen){
                     maxLen = j - i + 1;
                     begin = i;
                 }
             }
         }
         return s.substring(begin,begin+maxLen);
    }
}
