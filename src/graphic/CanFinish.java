package graphic;

import List.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanFinish {
    public boolean canFinish(int numCourses,int[][]prerequisites){
        int[]inDegrees = new int[numCourses];
        Queue<Integer>queue = new LinkedList<>();
        List<Integer>[] adjacency = new List[numCourses];
        for (int i = 0;i < numCourses;i++){
            adjacency[i] = new ArrayList<>();
        }
        for (int[]pre : prerequisites){
            inDegrees[pre[0]]++;
            adjacency[pre[1]].add(pre[0]);
        }
        for (int i = 0;i < numCourses;i++)
            if (inDegrees[i] == 0)
                queue.add(i);
            while (!queue.isEmpty()){
                int pre = queue.poll();
                numCourses--;
                for (int cur : adjacency[pre]){
                    if (--inDegrees[cur] == 0)
                        queue.add(cur);
                }
            }

        return numCourses == 0;
    }
    public boolean canFinishII(int numCourses,int[][]prerequisites){
        List<Integer>[]adjacency = new List[numCourses];
        for (int i = 0;i < numCourses;i++){
            adjacency[i] = new ArrayList<>();
        }
        for (int[]pre : prerequisites){
            adjacency[pre[1]].add(pre[0]);
        }
        int[]flags = new int[numCourses];
        for (int i = 0;i < numCourses;i++){
            if (!dfs(adjacency,flags,i))
                return false;
        }
        return true;
    }
    private boolean dfs(List<Integer>[]adjacency,int[]flags,int i){
        if (flags[i] == 1)
            return false;
        if (flags[i] == -1)
            return true;
        flags[i] = 1;
        for (int next : adjacency[i]){
            if (!dfs(adjacency,flags,next))
                return false;
        }
        flags[i] = -1;
        return true;
    }
}
