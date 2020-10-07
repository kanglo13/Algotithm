package interview;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kanglo
 * @create 2020-10-2020/10/6 20:47
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String>wordDict){
       int n = s.length();
       boolean[]dp = new boolean[n+1];
       dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1;i <= n;i++){
            for (int j = 0;j < i;j++){
                if (set.contains(s.substring(j,i)))
                    dp[i] |= dp[i-j];
            }
        }
        return dp[n];

    }
}
