package List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n,int[][]edges){
        List<Integer>result = new ArrayList<>();
        if (n <= 2){
            for (int i = 0;i < n;i++){
                result.add(i);
            }
            return result;
        }
        int[] degrees = new int[n];
        List<Integer>[]graphic = new List[n];
        Queue<Integer>queue = new LinkedList<>();
        for (int i = 0;i < n;i++){
            graphic[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            degrees[edge[0]]++;
            degrees[edge[1]]++;
            graphic[edge[0]].add(edge[1]);
            graphic[edge[1]].add(edge[0]);
        }
        for (int i = 0;i < n;i++){
            if (degrees[i] == 1)
                queue.offer(i);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            result = new ArrayList<>();
            while (size-- > 0){
                int cur = queue.poll();
                result.add(cur);
                for (int neighbour : graphic[cur]){
                    if (-- degrees[neighbour] == 1){
                        queue.offer(neighbour);
                    }
                }
            }
        }
        return result;
    }
}
