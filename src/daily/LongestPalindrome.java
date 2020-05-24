package daily;

public class LongestPalindrome {
    public String longestPalindrome(String s){
        int n = s.length();
        if (n < 2)
            return s;
        String res = s.substring(0,1);
        int maxLen = 0;
        for (int i = 0;i < n;i++){
            for (int j = i+1;j < n;j++){
                if ((j-i+1) > maxLen && isPalindrome(s,i,j)){
                    maxLen = j - i + 1;
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }
    private boolean isPalindrome(String s,int left,int right){
        while (left < right){
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
    private String longestPalindromeII(String s){
        int len = s.length();
        if (len < 2)
            return s;
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int begin = 0;
        for (int i = 0;i < len;i++){
            dp[i][i] = true;
        }
        for (int j = 1;j < len;j++){
            for (int i = 0;i < len;i++){
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }
                else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen){
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin,begin+ maxLen);
    }
}

