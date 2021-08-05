package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-08-2021/8/5 22:40
 */
public class EventualSafeNodes {
    public List<Integer> eventualSafeNodes(int[][]graph){
        List<Integer>result = new ArrayList<>();
        int n = graph.length;
        int[]color = new int[n];
        for (int i = 0;i < n;i++){
            if (dfs(i,color,graph))
                result.add(i);
        }
        return result;

    }
    private boolean dfs(int x,int[]color,int[][]graph){
        if (color[x] > 0)
            return color[x] == 2;
        color[x] = 1;
        for (int y : graph[x]){
            if(!dfs(y,color,graph))
                return false;
        }
        color[x] = 2;
        return true;

    }
}
