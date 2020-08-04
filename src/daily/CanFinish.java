package daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanFinish {
    public boolean canFinish(int numCourses,int[][]prerequisites){
        List<Integer>[]graphic = new List[numCourses];
        int[]indegrees = new int[numCourses];
        for (int i = 0;i < numCourses;i++){
            graphic[i] = new ArrayList<>();
        }
        for (int[]pre : prerequisites){
            graphic[pre[1]].add(pre[0]);
            indegrees[pre[0]]++;
        }
        Queue<Integer>queue = new LinkedList<>();
        for (int i = 0;i < numCourses;i++){
            if (indegrees[i] == 0)
                queue.add(i);
        }
        int count  = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                count++;
                int cur = queue.poll();
                for (int next : graphic[cur]){
                    if(--indegrees[next] == 0){
                        queue.add(next);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
