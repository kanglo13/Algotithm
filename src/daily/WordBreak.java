package daily;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict){
        int n = s.length();
        boolean[]dp = new boolean[n+1];
        Set<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        for (int r = 1;r < n+1;r++){
            for (int l = 0;l < r;l++){
                if (dp[l] && set.contains(s.substring(l,r))){
                    dp[r] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public boolean wordBreakII(String s,List<String>wordDict){
        int n = s.length();
        boolean[]dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1;i <= n;i++){
            for (String word : wordDict){
                int len = word.length();
                if (len <= i && word.equals(s.substring(i-len,i)))
                    dp[i] |= dp[i-len];
            }
        }
        return dp[n];
    }
}
