package search.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDistance {
    private int[][] direction = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    public int maxDistance(int[][]gird){
        int m = gird.length;
        int n = gird[0].length;
        Queue<int[]>queue = new LinkedList<>();
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (gird[i][j] == 1)
                    queue.add(new int[]{i,j});
            }
        }
        int[]point = null;
        while (!queue.isEmpty()){
            point = queue.poll();
            int r = point[0];
            int c = point[1];
            for (int[]d : direction){
                int nextR = r + d[0];
                int nextC = c + d[1];
                if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || gird[r][c] != 0)
                    continue;
                gird[nextR][nextC] = gird[r][c] + 1;
                queue.add(new int[]{nextR,nextC});
            }
        }
        return point == null ? -1 : gird[point[0]][point[1]];
    }
}
