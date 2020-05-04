package dynamicProgramming.knap;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict){
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for (int i = 1;i <= n;i++){
            for (String str : wordDict){
                int len = str.length();
                if (len <= i && str.equals(s.substring(i-len,i)))
                    dp[i] |= dp[i-len];
            }
        }
        return dp[n];
    }
}
