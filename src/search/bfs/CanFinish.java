package search.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanFinish {
    public boolean canFinish(int numCourse,int[][]prerequisites){
        int[]indegrees = new int[numCourse];
        List<Integer>[]adjacency = new List[numCourse];
        Queue<Integer>queue = new LinkedList<>();
        for (int i = 0;i < numCourse;i++){
            adjacency[i] = new ArrayList<>();
        }
        for (int[]pre : prerequisites){
            indegrees[pre[0]]++;
            adjacency[pre[1]].add(pre[0]);
        }
        for (int i = 0;i < numCourse;i++){
            if (indegrees[i] ==0)
                queue.add(i);
        }
        while (!queue.isEmpty()){
            int pre = queue.poll();
            numCourse--;
            for (int cur : adjacency[pre]){
                if (--indegrees[cur] ==0)
                    queue.add(cur);
            }
        }
        return numCourse == 0;
    }
}
