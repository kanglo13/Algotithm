package dynamicProgramming.subsequence;

public class CountSubstrings {
    public int countSubstrings(String s){
        int n = s.length();
        boolean[][]dp = new boolean[n][n];
        for (int i = 0;i < n;i++)
            dp[i][i] = true;
        int result = 0;
        for (int i = 0;i < n;i++){
            for (int j = 0;j < i;j++){
                if (s.charAt(i) != s.charAt(j))
                    dp[i][j] = false;
                else {
                    if ((i-j < 3) || dp[i+1][j-1]){
                        dp[i][j] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
