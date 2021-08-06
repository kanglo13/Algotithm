package daily;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author kanglo
 * @create 2021-08-2021/8/6 21:50
 */
public class ShortestPathLength {
    int INF = 0x3f3f3f3f;
    public int shortestPathLength(int[][]graph){
        int n = graph.length;
        int mask = 1 << n;
        int[][]dist = new int[mask][n];
        for (int i = 0;i < mask;i++){
            Arrays.fill(dist[i],INF);
        }
        Deque<int[]>queue = new ArrayDeque<>();
        for (int i =0;i < n;i++){
            queue.addLast(new int[]{1<<i,i});
            dist[1<<i][i] = 1;
        }
        while (!queue.isEmpty()){
            int[] cur = queue.pollFirst();
            int state = cur[0], u = cur[1],step = dist[state][u];
            if (state == mask - 1)
                return step - 1;
            for (int next : graph[u]){
                if (dist[state | 1 << next][next] == INF){
                    dist[state | 1 << next][next] = step + 1;
                    queue.addLast(new int[]{state| 1 << next,next});
                }
            }

        }
        return -1;
    }
}
