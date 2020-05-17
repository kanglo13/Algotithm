package daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindOrder {
    public int[]findOrder(int numCourse,int[][]prerequisites){
        if (numCourse == 0)
            return new int[0];
        int[]inDegrees = new int[numCourse];
        List<Integer>[] adjacency = new List[numCourse];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int[]result = new int[numCourse];
        for (int i = 0;i < numCourse;i++){
            adjacency[i] = new ArrayList<>();
        }
        for (int[]pre : prerequisites){
            inDegrees[pre[0]]++;
            adjacency[pre[1]].add(pre[0]);
        }

        for (int i = 0;i < numCourse;i++){
            if (inDegrees[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            result[count++] = cur;
            for (int next : adjacency[cur]){
                if (--inDegrees[next] == 0){
                    queue.add(next);
                }
            }
        }
        return  count == numCourse ? result : new int[0];
    }
}
