package daily;

import java.util.HashSet;
import java.util.Set;

public class Respace {
    public int respace(String[]dictionary,String sentence){
        Set<String> dict = new HashSet<>();
        for (String word : dictionary)
            dict.add(word);
        int len = sentence.length();
        int[]dp = new int[len+1];
        for (int i = 1;i <= len;i++){
            dp[i] = dp[i-1] + 1;
            for (int j = 0;j < i;j++){
                if (dict.contains(sentence.substring(j,i))){
                    dp[i] = Math.min(dp[i],dp[j]);
                }
            }
        }
        return dp[len];
    }
}
