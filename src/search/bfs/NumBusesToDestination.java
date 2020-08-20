package search.bfs;

import java.util.*;

/**
 * @author kanglo
 * @create 2020-08-2020/8/18 18:14
 */
public class NumBusesToDestination {
    public int  numBusesToDestination(int[][]routes,int S,int T){
        if (S == T)
            return 0;
        HashMap<Integer, List<Integer>>graph = new HashMap<>();
        for (int i = 0;i < routes.length;i++){
            for (int j = 0;j < routes[i].length;j++){
                graph.putIfAbsent(routes[i][j],new ArrayList<>());
                graph.get(routes[i][j]).add(i);
            }
        }
        Set<Integer>visited = new HashSet<>();
        Queue<Integer>queue = new LinkedList<>();
        queue.add(S);
        int round = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int cur = queue.poll();
                List<Integer>buses = graph.get(cur);
                for (int bus : buses){
                    if (visited.add(bus)){
                        for (int i = 0;i < routes[bus].length;i++){
                            int stop = routes[bus][i];
                            if (stop == T)
                                return round;
                            else
                                queue.offer(stop);
                        }
                    }
                }
            }
            round++;
        }
        return -1;
    }
}
