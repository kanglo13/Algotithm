package dynamicProgramming.wordBreak;

import sun.awt.image.ImageWatched;

import java.util.*;

public class WordBreakII {
    public List<String>wordBreak(String s,List<String>wordDict){
        int n = s.length();
        boolean []dp = new boolean[n+1];
        List<String>result = new ArrayList<>();
        dp[0] = true;
        Set<String>set = new HashSet<>(wordDict);
        for (int i = 1;i <= n;i++){
            for (int j = 0;j < i;j++){
                if (dp[j] && set.contains(s.substring(j,i)))
                    dp[i] = true;
                if (dp[i])
                    break;;
            }
        }
        if (dp[n]){
            LinkedList<String>queue = new LinkedList<>();
            backtracking(result,queue,set,dp,s,n);
        }
        return result;
    }
    private void backtracking(List<String>result, LinkedList<String>queue,Set<String>set,boolean[]dp,String s,int end){
        if (end == 0){
            StringBuilder stringBuilder = new StringBuilder();
            for (String word : queue){
                stringBuilder.append(word);
                stringBuilder.append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            result.add(stringBuilder.toString());
            return;
        }
        for (int i = 0;i < end;i++){
            if (dp[i]){
                String suffix = s.substring(i,end);
                if (set.contains(suffix)){
                    queue.addFirst(suffix);
                    backtracking(result,queue,set,dp,s,i);
                    queue.removeFirst();
                }
            }
        }
    }
}
