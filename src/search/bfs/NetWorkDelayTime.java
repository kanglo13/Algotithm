package search.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-08-2020/8/18 17:36
 */
public class NetWorkDelayTime {
    public int networkDelayTime(int[][]times,int N,int K){
        HashMap<Integer, List<int[]>>graph = new HashMap<>();
        for (int[]edge : times){
            graph.put(edge[0],new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        HashMap<Integer,Integer>distance = new HashMap<>();
        for (int i = 1;i <= N;i++){
            distance.put(i,Integer.MAX_VALUE);
        }
        distance.put(K,0);
        boolean[]hasVisited = new boolean[N+1];
        while (true){
            int minNode = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 1;i <= N;i++){
                if (!hasVisited[i] && distance.get(i) < minDistance){
                    minDistance = distance.get(i);
                    minNode = i;
                }
            }
            if (minNode == -1)
                break;
            hasVisited[minNode] = true;
            List<int[]>list = graph.get(minNode);
            if (list != null){
                for (int[]info : list){
                    int origin = distance.get(info[0]);
                    int direct = minDistance + info[1];
                    if (direct < origin)
                        distance.put(info[0],direct);
                }
            }
        }
        int res = 0;
        for (int cand : distance.values()){
            if (cand == Integer.MAX_VALUE)
                return -1;
            res = Math.max(res,cand);
        }
        return res;
    }
}
