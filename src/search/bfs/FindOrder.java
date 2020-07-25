package search.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindOrder {
    public int[]findOrder(int numCourses,int[][]prerequisites){
        int[]indegrees = new int[numCourses];
        List<Integer>[]adjacency = new List[numCourses];
        Queue<Integer>queue = new LinkedList<>();
        int[]result = new int[numCourses];
        int index = 0;
        for (int i = 0;i < numCourses;i++){
            adjacency[i] = new ArrayList<>();
        }
        for (int[]pre : prerequisites){
            indegrees[pre[0]]++;
            adjacency[pre[1]].add(pre[0]);
        }
        for (int i = 0;i < numCourses;i++){
            if (indegrees[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()){
            int pre = queue.poll();
            result[index++] = pre;
            for (int cur : adjacency[pre]){
                if (--indegrees[cur] == 0){
                    queue.add(cur);
                }
            }
        }
        if (index == numCourses)
            return result;
        return new int[0];
    }
}
