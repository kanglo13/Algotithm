package dynamicProgramming.sumary;

import java.util.*;

public class WordBreakII {
    public List<String>wordBreakII(String s,List<String>wordDict){
        int len = s.length();
        boolean[]dp = new boolean[len];
        Set<String>wordSet = new HashSet<>();
        for (String word: wordDict){
            wordSet.add(word);
        }
        for (int r = 0;r < len;r++){
            if (wordSet.contains(s.substring(0,r+1))){
                dp[r] = true;
                continue;
            }
            for (int l = 0;l < r;l++){
                if ( dp[l] && wordSet.contains(s.substring(l+1,r+1))){
                    dp[r] = true;
                    break;
                }
            }
        }
        List<String>result = new ArrayList<>();
        if (dp[len-1]){
            LinkedList<String>queue = new LinkedList<>();
            dfs(s,len-1,wordSet,result,queue,dp);
            return result;
        }
        return result;
    }
    private void dfs(String s, int end, Set<String>wordSet, List<String>result, LinkedList<String>queue,boolean[]dp){
        if (wordSet.contains(s.substring(0,end+1))){
            queue.addFirst(s.substring(0,end+1));
            StringBuilder stringBuilder = new StringBuilder();
            for (String word : queue){
                stringBuilder.append(word);
                stringBuilder.append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            result.add(stringBuilder.toString());
            queue.removeFirst();
        }
        for (int i = 0;i <end;i++){
            if (dp[i]){
                String suffix = s.substring(i+1,end+1);
                if (wordSet.contains(suffix)){
                    queue.addFirst(suffix);
                    dfs(suffix,i,wordSet,result,queue,dp);
                    queue.removeFirst();
                }
            }
        }
    }

}
