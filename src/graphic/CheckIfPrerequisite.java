package graphic;

import java.util.ArrayList;
import java.util.List;

public class CheckIfPrerequisite {
    List<Integer>[]graphic;
    int[][]dp;
    public List<Boolean>checkIfPrequisite(int n,int[][]prequsites,int[][]queries){
        buildGraphic(prequsites,n);
        dp = new int[n][n];
        List<Boolean>result = new ArrayList<>();
        for (int[]query : queries){
            result.add(dfs(query[0],query[1]));
        }
        return result;
    }
    private boolean dfs(int start,int end){
        if (dp[start][end] == 1)
            return true;
        if (dp[start][end] == -1)
            return false;
        if (start == end)
            return true;
        for (int next : graphic[start]){
            if (dfs(next,end)){
                dp[next][end] = 1;
                return true;
            }
        }
        dp[start][end] = -1;
        return false;
    }
    private void buildGraphic(int[][]prequisites,int n){
        graphic = new List[n];
        for (int i = 0;i < n;i++){
            graphic[i] = new ArrayList<>();
        }
        for (int[]pre : prequisites){
            graphic[pre[0]].add(pre[1]);
        }
    }
}
