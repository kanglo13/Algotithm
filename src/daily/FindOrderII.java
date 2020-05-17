package daily;

import java.util.ArrayList;
import java.util.List;

public class FindOrderII {
    private int count = 0;
    private int[]result;
    public int[] findOrder(int numCourses,int[][]prerequisites){
        if (numCourses == 0)
            return new int[0];
        List<Integer>[] adjacency = new List[numCourses];
        result = new int[numCourses];
        int[]flags = new int[numCourses];
        for (int i = 0;i < numCourses;i++){
            adjacency[i] = new ArrayList<>();
        }
        for (int[]pre : prerequisites){
            adjacency[pre[1]].add(pre[0]);
        }
        for (int i = 0;i < numCourses;i++){
            if (!dfs(adjacency,flags,i))
                return new int[0];
        }
        return result;
    }
    private boolean dfs(List<Integer>[]adjacency,int[]flags,int i){
        if (flags[i] == 1)
            return false;
        if (flags[i] == -1)
            return true;
        flags[i] = 1;
        for (int next : adjacency[i]){
            if(!dfs(adjacency,flags,next))
                return false;
        }
        flags[i] = -1;
        result[count++] = i;
        return true;
    }
}
