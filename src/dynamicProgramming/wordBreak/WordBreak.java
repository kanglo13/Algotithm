package dynamicProgramming.wordBreak;

import List.reverse.ListNode;
import jdk.nashorn.internal.ir.LiteralNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String>wordDict){
        int n = s.length();
        boolean[]dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1;i <= n;i++){
            for (String word : wordDict){
                int len = word.length();
                if ( len <= i&&s.substring(i-len,i).equals(word))
                    dp[i] |= dp[i-len];
            }
        }
        return dp[n];
    }
    public boolean wordBreakII(String s, List<String>wordDict){
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[]dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1;i <= n;i++){
            for (int j = 0;j < i;j++){
                dp[i] = dp[j] && set.contains(s.substring(j,i));
                if (dp[i])
                    break;
            }
        }
        return dp[n];
    }
}
