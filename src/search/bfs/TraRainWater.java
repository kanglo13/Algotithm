package search.bfs;

import java.util.PriorityQueue;

public class TraRainWater {
    public int trapRainWater(int[][]heightMap){
        if (heightMap == null || heightMap.length == 0)
            return 0;
        int m = heightMap.length, n = heightMap[0].length;
        int result = 0;
        boolean[][]visited = new boolean[m][n];
        int[][]direction = new int[][]{{0,1},{-1,0},{1,0},{0,-1}};
        PriorityQueue<int[]>queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[1]);

        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (i == 0 || j == 0 || i == m -1 || j == n - 1){
                    queue.offer(new int[]{i,j,heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()){
            int[]cur = queue.poll();
            for (int[]d : direction){
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]){
                    if (cur[2] > heightMap[r][c])
                        result += cur[2] - heightMap[r][c];
                    queue.offer(new int[]{r,c,Math.max(cur[2],heightMap[r][c])});
                    visited[r][c] = true;
                }
            }
        }
        return result;
    }
}
